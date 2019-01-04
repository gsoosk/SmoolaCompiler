package main.ast.node.statement;

import main.ast.Visitor;
import main.ast.node.Node;
import main.ast.node.expression.Expression;

public class Statement extends Node {

    @Override
    public String toString() {
        return "Statement";
    }
    private String code;
    public String getCode()
    {
        return code;
    }
    public void setCode(String _code) {code = _code;}
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
