package main.ast;

import com.sun.tools.javac.jvm.Code;
import main.Tools.CodeGenerator;
import main.Tools.TypeChecker;
import main.ast.node.Program;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.declaration.VarDeclaration;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.ast.node.expression.Value.StringValue;
import main.ast.node.statement.*;

import java.util.ArrayList;

public class CodeGenerationVisitor implements Visitor {
    public static boolean inMain = false;
    private static boolean passMain = false;
    private static String currentClassName = "";
    private static String currentMethodName = "";
    @Override
    public void visit(Program program) {
        program.getMainClass().accept(this);
        for (ClassDeclaration aClass : program.getClasses()) {
            aClass.accept(this);
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        if(!passMain)
        {
            inMain = true;
            passMain = true;
        }
        currentClassName = classDeclaration.getName().getName();
        TypeChecker.setForIdentifier(currentClassName, "");

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


        String classCode = CodeGenerator.generateCode(classDeclaration);
        CodeGenerator.jasminFileCreator(classCode, classDeclaration.getName().getName());
        inMain = false;
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {

        currentMethodName = methodDeclaration.getName().getName();
        TypeChecker.setForIdentifier(currentClassName, currentMethodName);

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

        CodeGenerator.generateCode(methodDeclaration);
        TypeChecker.setForIdentifier(currentClassName, "");

    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        CodeGenerator.generateCode(varDeclaration);
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
        CodeGenerator.generateCode(arrayCall);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
        CodeGenerator.generateCode(binaryExpression);
    }

    @Override
    public void visit(Identifier identifier) {
        CodeGenerator.generateCode(identifier);
    }

    @Override
    public void visit(Length length) {
        length.getExpression().accept(this);
        CodeGenerator.generateCode(length);
    }

    @Override
    public void visit(MethodCall methodCall) {
        methodCall.getInstance().accept(this);
        methodCall.getMethodName().accept(this);
        ArrayList<Expression> args = methodCall.getArgs();
        for (Expression arg : args) {
            arg.accept(this);
        }
        CodeGenerator.generateCode(methodCall);
    }

    @Override
    public void visit(NewArray newArray) {
        newArray.getExpression().accept(this);
        CodeGenerator.generateCode(newArray);
    }

    @Override
    public void visit(NewClass newClass) {
        CodeGenerator.generateCode(newClass);
    }

    @Override
    public void visit(This instance) {
        CodeGenerator.generateCode(instance);
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getValue().accept(this);
        CodeGenerator.generateCode(unaryExpression);
    }

    @Override
    public void visit(BooleanValue value) {
        CodeGenerator.generateCode(value);
    }

    @Override
    public void visit(IntValue value) {
        CodeGenerator.generateCode(value);
    }

    @Override
    public void visit(StringValue value) {
        CodeGenerator.generateCode(value);
    }

    @Override
    public void visit(Assign assign) {
        assign.getlValue().accept(this);
        assign.getrValue().accept(this);
        CodeGenerator.generateCode(assign);
    }

    @Override
    public void visit(Block block) {
        ArrayList<Statement> body =  block.getBody();
        for (Statement aBody : body) {
            aBody.accept(this);
        }
        CodeGenerator.generateCode(block);
    }

    @Override
    public void visit(Conditional conditional) {
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if(conditional.getAlternativeBody() != null)
            conditional.getAlternativeBody().accept(this);
        CodeGenerator.generateCode(conditional);

    }

    @Override
    public void visit(While loop) {
        loop.getCondition().accept(this);
        loop.getBody().accept(this);
        CodeGenerator.generateCode(loop);
    }

    @Override
    public void visit(Write write) {
        write.getArg().accept(this);
        CodeGenerator.generateCode(write);
    }

    @Override
    public void visit(Statement statement) {
        if(statement.getExpression() != null)
        {
            statement.getExpression().accept(this);
            statement.setCode(statement.getExpression().getCode());
        }
    }
}
