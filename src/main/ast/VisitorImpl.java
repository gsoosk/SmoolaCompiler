package main.ast;

import javafx.util.Pair;
import main.Tools.HashMaker;
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
import main.ast.Type.UserDefinedType.UserDefinedType;
import sun.awt.Symbol;
import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.ArrayList;
import java.util.HashMap;

public class VisitorImpl implements Visitor {
    private boolean isThereError = false;
    private boolean isItInClassVarDeclarations = false;
    private int variablesIndex = 0;
    private String currentClassName;
    private String currentParentName;
    private ArrayList<PassSaver> passSavers = new ArrayList<>();
    private ArrayList< Pair<String , String> > ArrayOfClasses = new ArrayList<>();

    private HashMap<String, SymbolTable> allClassesSymbolTable = new HashMap<String, SymbolTable>();
    private HashMap<String, SymbolTable> allMethodsSymbolTable = new HashMap<String, SymbolTable>();



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

        //Accepting main
        currentClassName = program.getMainClass().getName().getName();
        if(program.getMainClass().getParentName() != null)
            currentParentName = program.getMainClass().getParentName().getName();
        else
            currentParentName = null;
        Pair < String , String > mainClass = new Pair<>(currentClassName, currentParentName);
        ArrayOfClasses.add(mainClass);
        program.getMainClass().accept(this);
        //Accepting otherClasses;
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

        allClassesSymbolTable =  HashMaker.makeHash(ArrayOfClasses, allClassesSymbolTable);
        Visitor secondVisitor = new SecondPassVisitor(allClassesSymbolTable, allMethodsSymbolTable, isThereError, variablesIndex);
        secondVisitor.visit(program);

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
                String newName = "temp_class_"+ Integer.toString(i) + classDeclaration.getName().getName();
                classDeclaration.setName(new Identifier(newName));
                classItem.setName(classDeclaration.getName().getName());
                Pair < String , String > newClass = new Pair<>(newName, currentParentName);
                ArrayOfClasses.set(ArrayOfClasses.size() - 1, newClass);
                currentClassName = newName;
            }
        }while (!putSuccess);
        // Adding SymbolTable
        SymbolTable classSymbolTable = new SymbolTable(SymbolTable.top);
        SymbolTable.push(classSymbolTable);
        //


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
        allClassesSymbolTable.put(currentClassName, SymbolTable.pop());

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



        methodDeclaration.getName().accept(this);

        ArrayList<VarDeclaration> args = methodDeclaration.getArgs();
        for (VarDeclaration arg : args) {
            arg.accept(this);
        }



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
        allMethodsSymbolTable.put(currentClassName + "-" + methodDeclaration.getName().getName() ,SymbolTable.pop());
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


        varDeclaration.getIdentifier().accept(this);



    }

    @Override
    public void visit(ArrayCall arrayCall) {

        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {

        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {

    }

    @Override
    public void visit(Length length) {

       length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {

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

        newArray.getExpression().accept(this);
    }

    @Override
    public void visit(NewClass newClass) {
        newClass.getClassName().accept(this);
    }

    @Override
    public void visit(This instance) {
        UserDefinedType type = new UserDefinedType();
        type.setName(new Identifier(currentClassName));
        instance.setType(type);
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {

        unaryExpression.getValue().accept(this);
    }

    @Override
    public void visit(BooleanValue value) {

    }

    @Override
    public void visit(IntValue value) {

    }

    @Override
    public void visit(StringValue value) {

    }

    @Override
    public void visit(Assign assign) {

        assign.getlValue().accept(this);
        assign.getrValue().accept(this);
    }

    @Override
    public void visit(Block block) {


        ArrayList<Statement> body =  block.getBody();
        for (Statement aBody : body) {
            aBody.accept(this);
        }


    }

    @Override
    public void visit(Conditional conditional) {
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if(conditional.getAlternativeBody() != null)
            conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {

        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {

        write.getArg().accept(this);
    }
}
