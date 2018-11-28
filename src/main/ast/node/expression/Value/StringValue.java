package main.ast.node.expression.Value;

import main.ast.Type.Type;
import main.ast.Visitor;

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

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
