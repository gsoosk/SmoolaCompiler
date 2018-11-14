package ast.node.expression;

import ast.Visitor;

public class NewClass extends Expression {
    private Identifier className;

    public NewClass(Identifier className) {
        this.className = className;
    }

    public Identifier getClassName() {
        return className;
    }

    public void setClassName(Identifier className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "NewClass";
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
