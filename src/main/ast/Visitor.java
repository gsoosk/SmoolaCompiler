package main.ast;

import main.ast.node.Program;
import main.ast.node.Node;
import main.ast.node.declaration.*;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.*;
import main.ast.node.statement.*;


public interface Visitor {
    void visit (Program program);

    //Declarations
    void visit (ClassDeclaration classDeclaration);
    void visit (MethodDeclaration methodDeclaration);
    void visit (VarDeclaration varDeclaration);

    //Expressions
    void visit(ArrayCall arrayCall);
    void visit(BinaryExpression binaryExpression);
    void visit(Identifier identifier);
    void visit(Length length);
    void visit(MethodCall methodCall);
    void visit(NewArray newArray);
    void visit(NewClass newClass);
    void visit(This instance);
    void visit(UnaryExpression unaryExpression);
    void visit(BooleanValue value);
    void visit(IntValue value);
    void visit(StringValue value);

    //Statements
    void visit(Assign assign);
    void visit(Block block);
    void visit(Conditional conditional);
    void visit(While loop);
    void visit(Write write);
}
