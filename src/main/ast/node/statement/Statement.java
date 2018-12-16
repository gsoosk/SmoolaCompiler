package main.ast.node.statement;

import main.ast.Visitor;
import main.ast.node.Node;
import main.ast.node.expression.Expression;

public class Statement extends Node {

    @Override
    public String toString() {
        return "Statement";
    }

    Expression expression;
    public void setExpression(Expression expr)
    {
        expression = expr;
    }
    public Expression getExpression()
    {
        return expression;
    }
    @Override
    public void accept(Visitor visitor) {visitor.visit(this);}
}
