package main.ast.node.expression;

import main.ast.Type.Type;
import main.ast.Visitor;
import main.ast.node.Node;

public abstract class Expression extends Node{
    private Type type;
    private String code;

    public Type getType() {
        return type;
    }
    public String getCode()
    {
        return code;
    }
    public void setCode(String _code)
    {
        this.code = _code;
    }

    public void setType(Type type) {
        this.type = type;
    }
    @Override
    public void accept(Visitor visitor) {
    }
}