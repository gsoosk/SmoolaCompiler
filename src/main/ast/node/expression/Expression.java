package main.ast.node.expression;

import main.ast.Type.Type;
import main.ast.node.Node;

public abstract class Expression extends Node{
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}