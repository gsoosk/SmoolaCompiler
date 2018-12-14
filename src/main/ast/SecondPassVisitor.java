package main.ast;

import main.Tools.TypeChecker;
import main.ast.Type.NoType;
import main.ast.Type.*;
import main.ast.Type.PrimitiveType.*;
import main.ast.Type.ArrayType.*;
import main.ast.Type.OkType;
import main.ast.Type.PrimitiveType.BooleanType;
import main.ast.Type.UserDefinedType.UserDefinedType;
import main.ast.Type.Type;
import main.ast.node.Program;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.declaration.VarDeclaration;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.ast.node.expression.Value.StringValue;
import main.ast.node.statement.*;
import main.symbolTable.ItemAlreadyExistsException;
import main.symbolTable.SymbolTable;
import main.symbolTable.SymbolTableItem;
import main.symbolTable.SymbolTableVariableItemBase;

import java.util.ArrayList;
import java.util.HashMap;


public class SecondPassVisitor implements  Visitor{
    private Program program;
    private HashMap<String, SymbolTable> allClassesSymbolTable ;
    private HashMap<String, SymbolTable> allMethodsSymbolTable ;
    private String currentClassName ;
    private String currentMethodName;
    private boolean isThereError;
    private boolean inMethod;
    private boolean inMethodCall = false;
    private ArrayList<String> toOut = new ArrayList<>();
    private int variablesIndex;
    public SecondPassVisitor(HashMap<String, SymbolTable> allClasses, HashMap<String, SymbolTable> allMethods, boolean error, int varIndex)
    {
        allClassesSymbolTable = allClasses;
        allMethodsSymbolTable = allMethods;
        isThereError = error;
        variablesIndex = varIndex;
        TypeChecker.setHashesForIdentifier(allClasses, allMethods);
    }
    private void setUserDefinedTypeClassDeclaration(Type udt) {
        for (ClassDeclaration classDeclaration : program.getClasses()) {
            if (classDeclaration.getName().getName() == ((UserDefinedType)udt).getName().getName()) {
                ((UserDefinedType)udt).setClassDeclaration(classDeclaration);
            }
        }
    }

    @Override
    public void visit(Program program) {
        this.program = program;
        toOut.add(program.toString());
        program.getMainClass().accept(this);
        for (ClassDeclaration aClass : program.getClasses()) {
            aClass.accept(this);
        }

        if(!isThereError)
        {
            for (String aToOut : toOut) {
                System.out.println(aToOut);
            }
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        currentClassName = classDeclaration.getName().getName();
        TypeChecker.setForIdentifier(currentClassName, currentMethodName);

        toOut.add(classDeclaration.toString());
        classDeclaration.getName().accept(this);
        if (classDeclaration.getParentName() != null)
            classDeclaration.getParentName().accept(this);

        ArrayList<VarDeclaration> varDeclarations = classDeclaration.getVarDeclarations();
        for (VarDeclaration varDeclaration : varDeclarations) {
            varDeclaration.accept(this);
        }

        ArrayList<MethodDeclaration> methodDeclarations = classDeclaration.getMethodDeclarations();
        for (MethodDeclaration methodDeclaration : methodDeclarations) {
            methodDeclaration.accept(this);
        }
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {

        toOut.add(methodDeclaration.toString());
        methodDeclaration.getName().accept(this);

        ArrayList<VarDeclaration> args = methodDeclaration.getArgs();
        for (VarDeclaration arg : args) {
            arg.accept(this);
        }

        ArrayList<VarDeclaration> varDeclarations = methodDeclaration.getLocalVars();
        for (VarDeclaration varDeclaration : varDeclarations) {
            varDeclaration.accept(this);
        }
        inMethod = true;
        currentMethodName = methodDeclaration.getName().getName();
        TypeChecker.setForIdentifier(currentClassName, currentMethodName);
        Type returnType = methodDeclaration.getReturnType();
        Expression returnValue = methodDeclaration.getReturnValue();
        Type eReturnType = TypeChecker.expressionTypeCheck(returnValue);
        if (!returnType.getClass().equals(eReturnType.getClass())) {
            System.out.println("Line:" + returnValue.getLineNumber() + ":" + methodDeclaration.getName().getName()
                    + " return type must be " + ((UserDefinedType)returnType).getName().getName());
        } else {
            if (returnType instanceof UserDefinedType) {
                String t = ((UserDefinedType)eReturnType).getName().getName();
                String p = ((UserDefinedType)returnType).getName().getName();
                if (!TypeChecker.isSubtypeOf(t, p)) {
                    System.out.println("Line:" + returnValue.getLineNumber() + ":" + methodDeclaration.getName().getName()
                    + " return type must be " + ((UserDefinedType)returnType).getName().getName());
                }
            }
        }
        ArrayList<Statement> statements = methodDeclaration.getBody();

        for (Statement statement : statements) {
            statement.accept(this);
        }

        methodDeclaration.getReturnValue().accept(this);
        inMethod = false;
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        toOut.add(varDeclaration.toString());
        varDeclaration.getIdentifier().accept(this);
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        toOut.add(arrayCall.toString());
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        if(TypeChecker.expressionTypeCheck(binaryExpression) instanceof NoType)
            handleUnsupportedOperationException(binaryExpression.getBinaryOperator().name(), binaryExpression);

        toOut.add(binaryExpression.toString());
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {

        if(inMethod && !inMethodCall)
            if(!allClassesSymbolTable.get(currentClassName).getItems().containsKey(identifier.getName())
                && !allMethodsSymbolTable.get(currentClassName + "-" + currentMethodName).getItems().containsKey(identifier.getName()))
            {
                isThereError = true;
                System.out.println("Line:" + identifier.getLineNumber() + ":variable " + identifier.getName() + " is not declared");
                SymbolTableItem item = new SymbolTableVariableItemBase(identifier.getName(),
                        new NoType(), ++variablesIndex);
                try{
                    allClassesSymbolTable.get(currentClassName).put(item);
                } catch (ItemAlreadyExistsException ex) {}
            }

        toOut.add(identifier.toString());
    }

    @Override
    public void visit(Length length) {
        toOut.add(length.toString());
        length.getExpression().accept(this);

    }

    @Override
    public void visit(MethodCall methodCall) {
        inMethodCall = true;
        if(TypeChecker.expressionTypeCheck(methodCall) instanceof NoType)
            isThereError = true;
        toOut.add(methodCall.toString());
        methodCall.getInstance().accept(this);
        methodCall.getMethodName().accept(this);

        ArrayList<Expression> args = methodCall.getArgs();
        for (Expression arg : args) {
            arg.accept(this);
        }
        inMethodCall = false;
    }

    @Override
    public void visit(NewArray newArray) {
        toOut.add(newArray.toString());
        newArray.getExpression().accept(this);
    }

    @Override
    public void visit(NewClass newClass) {
        toOut.add(newClass.toString());
        newClass.getClassName().accept(this);
    }

    @Override
    public void visit(This instance) {
        toOut.add(instance.toString());

    }

    private void handleUnsupportedOperationException(String operatorName, Expression expr)
    {
        this.isThereError = true;
        System.out.println("Line:"+ expr.getLineNumber() +":unsupported operand type for "+ operatorName);
    }
    @Override
    public void visit(UnaryExpression unaryExpression) {
        if(TypeChecker.expressionTypeCheck(unaryExpression) instanceof NoType)
            handleUnsupportedOperationException(unaryExpression.getUnaryOperator().name(), unaryExpression);
        toOut.add(unaryExpression.toString());
        unaryExpression.getValue().accept(this);
    }

    @Override
    public void visit(BooleanValue value) {
        toOut.add(value.toString());

    }

    @Override
    public void visit(IntValue value) {
        toOut.add(value.toString());
    }

    @Override
    public void visit(StringValue value) {
        toOut.add(value.toString());
    }

    @Override
    public void visit(Assign assign) {
        toOut.add(assign.toString());
        assign.getlValue().accept(this);
        assign.getrValue().accept(this);
    }

    @Override
    public void visit(Block block) {
        toOut.add(block.toString());
        ArrayList<Statement> body =  block.getBody();
        for (Statement aBody : body) {
            aBody.accept(this);
        }
    }
    private void conditionCheck(Expression cond)
    {
        if(!(TypeChecker.expressionTypeCheck(cond) instanceof BooleanType))
        {
            isThereError = true;
            System.out.println("Line:" + cond.getLineNumber() + ":condition type must be boolean");
        }
    }
    @Override
    public void visit(Conditional conditional) {
        conditionCheck(conditional.getExpression());
        toOut.add(conditional.toString());
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if(conditional.getAlternativeBody() != null)
            conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {
        conditionCheck(loop.getCondition());
        toOut.add(loop.toString());
        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        Type t = TypeChecker.expressionTypeCheck(write.getArg());
        if (!(t instanceof IntType ||  t instanceof StringType || t instanceof ArrayType)) {
            System.out.println("Line:"+ write.getArg().getLineNumber() +":unsupported type for writeln");
        }
        toOut.add(write.toString());
        write.getArg().accept(this);
    }
}
