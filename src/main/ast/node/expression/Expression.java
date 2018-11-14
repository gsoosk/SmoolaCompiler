package ast.node.expression;

import ast.Type.Type;
import ast.node.Node;

public abstract class Expression extends Node{
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}