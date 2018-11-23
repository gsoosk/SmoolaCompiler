package main.ast;

import main.ast.node.Node;
import main.ast.node.Program;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MainMethodDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.declaration.VarDeclaration;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.ast.node.expression.Value.StringValue;
import main.ast.node.statement.*;

import java.util.ArrayList;

public class VisitorImpl implements Visitor {
    @Override
    public void visit(Program program) {
        System.out.println(program.toString());
        program.getMainClass().accept(this);
        ArrayList<ClassDeclaration> classes = program.getClasses();
        for(int i = 0 ;  i < classes.size() ; i++)
        {
            classes.get(i).accept(this);
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        System.out.println(classDeclaration.toString());

        classDeclaration.getName().accept(this);
        classDeclaration.getParentName().accept(this);

        ArrayList<VarDeclaration> varDeclarations = classDeclaration.getVarDeclarations();
        for (int i = 0; i < varDeclarations.size(); i++) {
            varDeclarations.get(i).accept(this);
        }

        ArrayList<MethodDeclaration> methodDeclarations = classDeclaration.getMethodDeclarations();
        for (int i = 0; i < methodDeclarations.size(); i++) {
            methodDeclarations.get(i).accept(this);
        }

    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        System.out.println(methodDeclaration.toString());

        methodDeclaration.getName().accept(this);

        ArrayList<VarDeclaration> args = methodDeclaration.getArgs();
        for (int i = 0; i < args.size(); i++) {
            args.get(i).accept(this);
        }

        System.out.println(methodDeclaration.getReturnType().toString());

        ArrayList<VarDeclaration> varDeclarations = methodDeclaration.getLocalVars();
        for (int i = 0; i < varDeclarations.size(); i++) {
            varDeclarations.get(i).accept(this);
        }

        ArrayList<Statement> statements = methodDeclaration.getBody();
        for (int i = 0; i < statements.size(); i++) {
            statements.get(i).accept(this);
        }

        methodDeclaration.getReturnValue().accept(this);
    }

    @Override
    public void visit(MainMethodDeclaration mainMethodDeclaration) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Identifier identifier) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Length length) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(MethodCall methodCall) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(NewArray newArray) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(NewClass newClass) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(This instance) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(BooleanValue value) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(IntValue value) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(StringValue value) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Assign assign) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Block block) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Conditional conditional) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(While loop) {
        //TODO: implement appropriate visit functionality
    }

    @Override
    public void visit(Write write) {
        //TODO: implement appropriate visit functionality
    }
}
