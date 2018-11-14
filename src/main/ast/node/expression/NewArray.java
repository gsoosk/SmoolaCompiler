package ast.node.expression;

import ast.Visitor;

public class NewArray extends Expression {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "NewArray";
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
