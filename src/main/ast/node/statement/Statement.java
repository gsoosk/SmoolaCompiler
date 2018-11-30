package main.ast.node.statement;

import main.ast.Visitor;
import main.ast.node.Node;

public class Statement extends Node {

    @Override
    public String toString() {
        return "Statement";
    }

    @Override
    public void accept(Visitor visitor) {}
}
