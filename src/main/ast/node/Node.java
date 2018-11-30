package main.ast.node;

import main.ast.Visitor;
import main.ast.VisitorImpl;

public abstract class Node {
    private int lineNumber;

    public void accept(Visitor visitor) {}
    public void setLineNumber(int lineNo) {
        this.lineNumber = lineNo;
    }
    public int getLineNumber() {
        return this.lineNumber;
    }
}
