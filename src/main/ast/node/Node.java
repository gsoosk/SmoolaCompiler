package main.ast.node;

import main.ast.Visitor;
import main.ast.VisitorImpl;

public abstract class Node {

    public void accept(Visitor visitor) {}
}
