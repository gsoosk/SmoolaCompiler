package main.ast.node.declaration;

import main.ast.Visitor;
import main.ast.node.Node;

public abstract class Declaration extends Node {
    @Override
    public void accept(Visitor visitor) {}
}