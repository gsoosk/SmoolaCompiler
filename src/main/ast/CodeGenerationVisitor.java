package main.ast;

import com.sun.tools.javac.jvm.Code;
import main.Tools.CodeGenerator;
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
    @Override
    public void visit(Program program) {
        program.getMainClass().accept(this);
        for (ClassDeclaration aClass : program.getClasses()) {
            aClass.accept(this);
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {


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
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {

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

    }

    @Override
    public void visit(VarDeclaration varDeclaration) {

    }

    @Override
    public void visit(ArrayCall arrayCall) {

    }

    @Override
    public void visit(BinaryExpression binaryExpression) {

    }

    @Override
    public void visit(Identifier identifier) {

    }

    @Override
    public void visit(Length length) {

    }

    @Override
    public void visit(MethodCall methodCall) {

    }

    @Override
    public void visit(NewArray newArray) {

    }

    @Override
    public void visit(NewClass newClass) {

    }

    @Override
    public void visit(This instance) {

    }

    @Override
    public void visit(UnaryExpression unaryExpression) {

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

    }

    @Override
    public void visit(Block block) {

    }

    @Override
    public void visit(Conditional conditional) {

    }

    @Override
    public void visit(While loop) {

    }

    @Override
    public void visit(Write write) {

    }

    @Override
    public void visit(Statement statement) {

    }
}
