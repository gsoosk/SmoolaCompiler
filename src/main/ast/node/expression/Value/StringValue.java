package ast.node.expression.Value;

import ast.Type.Type;
import ast.Visitor;

public class StringValue extends Value {
    private String constant;

    public StringValue(String constant, Type type) {
        this.constant = constant;
        this.type = type;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "StringValue " + constant;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
