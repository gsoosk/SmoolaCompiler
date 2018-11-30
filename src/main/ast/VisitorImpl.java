package main.ast;

import javafx.util.Pair;
import main.Tools.PassSaver;
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
import main.symbolTable.*;
import sun.awt.Symbol;
import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.ArrayList;

public class VisitorImpl implements Visitor {
    private boolean isThereError = false;
    private boolean isItInClassVarDeclarations = false;
    private ArrayList<String> toOut = new ArrayList<>();
    private int variablesIndex = 0;
    private String currentClassName;
    private String currentParentName;
    private ArrayList<PassSaver> passSavers = new ArrayList<>();
    private ArrayList< Pair<String , String> > ArrayOfClasses = new ArrayList<>();

    private boolean reCheck(String target, String current)
    {

        for (Pair<String, String> singleClass:
            ArrayOfClasses) {
            if(singleClass.getKey().equals(current) && singleClass.getValue()!= null)
                if(singleClass.getValue().equals(target))
                    return true;
        }
        for (Pair<String, String> singleClass:
             ArrayOfClasses) {

            if(singleClass.getKey().equals(current))
            {
                if(singleClass.getValue() != null)
                    return reCheck(target, singleClass.getValue());
                else
                    return false;
            }
        }
        return false;
    }
    private boolean isItOkToAdd(String methodName, String parentName, String className, boolean methodOrNot)
    {
        for (PassSaver passSaver : passSavers) {
            if (passSaver.doesItHaveConflict(methodName, className, parentName, methodOrNot))
                return false;
        }


        for(PassSaver passSaver : passSavers)
        {
            if(passSaver.isEqual(methodName, methodOrNot))
            {
                if(parentName != null) {
                    if(reCheck(passSaver.getClassName(), className)) {
                        return false;
                    }
                }
                if(reCheck(className, passSaver.getClassName())){
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void visit(Program program) {
        // For making symbol table
        SymbolTable.push(new SymbolTable());
        // For preorder traversal
        toOut.add(program.toString());
        program.getMainClass().accept(this);
        ArrayList<ClassDeclaration> classes = program.getClasses();
        for (ClassDeclaration aClass : classes) {
            currentClassName = aClass.getName().getName();
            if(aClass.getParentName() != null)
                currentParentName = aClass.getParentName().getName();
            else
                currentParentName = null;
            Pair < String , String > newClass = new Pair<>(currentClassName, currentParentName);
            ArrayOfClasses.add(newClass);
            aClass.accept(this);
        }


        if(!isThereError)
        {
            for (String aToOut : toOut) {
                System.out.println(aToOut);
            }
        }

//        for (PassSaver passSaver : passSavers) {
//            passSaver.print();
//        }

    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        //
        SymbolTableClassItem classItem = new SymbolTableClassItem(classDeclaration.getName().getName());
        boolean putSuccess = false;
        int i = 0;
        do {
            try {
                SymbolTable.top.put(classItem);
                putSuccess = true;
            } catch (ItemAlreadyExistsException ex) {
                i++;
                if(i == 1){
                    isThereError = true;
                    String Error = "Line:"
                            + Integer.toString(classDeclaration.getLineNumber())
                            + ":Redefinition of class "
                            + classDeclaration.getName().getName();
                    System.out.println(Error);
                }
                classDeclaration.setName(new Identifier("temp_class_"+ Integer.toString(i) + classDeclaration.getName().getName()));
                classItem.setName(classDeclaration.getName().getName());
            }
        }while (!putSuccess);

        SymbolTable classSymbolTable = new SymbolTable(SymbolTable.top);
        SymbolTable.push(classSymbolTable);

        //
        toOut.add(classDeclaration.toString());

        classDeclaration.getName().accept(this);
        if (classDeclaration.getParentName() != null)
            classDeclaration.getParentName().accept(this);

        isItInClassVarDeclarations = true;
        ArrayList<VarDeclaration> varDeclarations = classDeclaration.getVarDeclarations();
        for (VarDeclaration varDeclaration : varDeclarations) {
            varDeclaration.accept(this);
        }
        isItInClassVarDeclarations = false;

        ArrayList<MethodDeclaration> methodDeclarations = classDeclaration.getMethodDeclarations();
        for (MethodDeclaration methodDeclaration : methodDeclarations) {
            methodDeclaration.accept(this);
        }

        //
        SymbolTable.pop();

    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        //
        ArrayList<Type> argsType = new ArrayList<>();
        for (VarDeclaration arg: methodDeclaration.getArgs()) {
          argsType.add(arg.getType());
        }
        SymbolTableMethodItem methodItem = new SymbolTableMethodItem(methodDeclaration.getName().getName(),
                                                                    argsType);
        boolean putSuccess = false;
        int i = 0;
        do {
            try {
                if(!isItOkToAdd(methodDeclaration.getName().getName(), currentParentName, currentClassName, true))
                    throw new ItemAlreadyExistsException();
                SymbolTable.top.put(methodItem);
                passSavers.add(new PassSaver(methodDeclaration.getName().getName(), currentParentName, currentClassName, true));
                putSuccess = true;
            } catch (ItemAlreadyExistsException ex) {
                i++;
                if(i == 1){
                    isThereError = true;
                    String Error = "Line:"
                            + Integer.toString(methodDeclaration.getLineNumber())
                            + ":Redefinition of method "
                            + methodDeclaration.getName().getName();

                    System.out.println(Error);
                }
                methodDeclaration.setName(new Identifier("temp_method_"+ Integer.toString(i) + methodDeclaration.getName().getName()));
                methodItem.setName(methodDeclaration.getName().getName());
            }
        }while (!putSuccess);

        SymbolTable scopeSymbolTable = new SymbolTable(SymbolTable.top);
        SymbolTable.push(scopeSymbolTable);
        //

        toOut.add(methodDeclaration.toString());

        methodDeclaration.getName().accept(this);

        ArrayList<VarDeclaration> args = methodDeclaration.getArgs();
        for (VarDeclaration arg : args) {
            arg.accept(this);
        }

//        toOut.add(methodDeclaration.getReturnType().toString());

        ArrayList<VarDeclaration> varDeclarations = methodDeclaration.getLocalVars();
        for (VarDeclaration varDeclaration : varDeclarations) {
            varDeclaration.accept(this);
        }

        ArrayList<Statement> statements = methodDeclaration.getBody();

        for (Statement statement : statements) {
            statement.accept(this);
        }

        methodDeclaration.getReturnValue().accept(this);

        //
        SymbolTable.pop();
    }


    @Override
    public void visit(VarDeclaration varDeclaration) {

        SymbolTableItem item = new SymbolTableVariableItemBase(varDeclaration.getIdentifier().getName(),
                                    varDeclaration.getType(), ++variablesIndex);
        boolean putSuccess = false;
        int i = 0;
        do {
            try {
                if(isItInClassVarDeclarations)
                    if(!isItOkToAdd(varDeclaration.getIdentifier().getName(), currentParentName, currentClassName, false))
                        throw new ItemAlreadyExistsException();
                SymbolTable.top.put(item);
                if(isItInClassVarDeclarations)
                    passSavers.add(new PassSaver(varDeclaration.getIdentifier().getName(), currentParentName, currentClassName, false));
                putSuccess = true;
            } catch (ItemAlreadyExistsException ex) {
                i++;
                if(i == 1){
                    isThereError = true;
                    String Error = "Line:"
                            + Integer.toString(varDeclaration.getLineNumber())
                            + ":Redefinition of variable "
                            + varDeclaration.getIdentifier().getName();

                    System.out.println(Error);
                }
                varDeclaration.setIdentifier(new Identifier("temp_var_"+ Integer.toString(i) + varDeclaration.getIdentifier().getName()));
                item.setName(varDeclaration.getIdentifier().getName());
            }
        }while (!putSuccess);

        toOut.add(varDeclaration.toString());
        varDeclaration.getIdentifier().accept(this);

//        toOut.add(varDeclaration.getType().toString());

    }

    @Override
    public void visit(ArrayCall arrayCall) {
        toOut.add(arrayCall.toString());
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        toOut.add(binaryExpression.toString());
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {
        toOut.add(identifier.toString());
    }

    @Override
    public void visit(Length length) {
       toOut.add(length.toString());
       length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {
       toOut.add(methodCall.toString());
       methodCall.getInstance().accept(this);
       methodCall.getMethodName().accept(this);

        ArrayList<Expression> args = methodCall.getArgs();
        for (Expression arg : args) {
            arg.accept(this);
        }
    }

    @Override
    public void visit(NewArray newArray) {
        if(((IntValue) newArray.getExpression()).getConstant() <= 0)
        {
            isThereError = true;
            String Error = "Line:"
                    + Integer.toString(newArray.getLineNumber())
                    + ":Array length should not be zero or negative";
            System.out.println(Error);
            ((IntValue) newArray.getExpression()).setConstant(0);
        }
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

    @Override
    public void visit(UnaryExpression unaryExpression) {
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

    @Override
    public void visit(Conditional conditional) {
        toOut.add(conditional.toString());
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {
        toOut.add(loop.toString());
        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        toOut.add(write.toString());
        write.getArg().accept(this);
    }
}
