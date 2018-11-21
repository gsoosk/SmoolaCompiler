package main.ast.node.expression.Value;

import main.ast.Type.Type;
import main.ast.Visitor;

public class IntValue extends Value {
    private int constant;

    public IntValue(int constant, Type type) {
        this.constant = constant;
        this.type = type;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "IntValue " + constant;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
