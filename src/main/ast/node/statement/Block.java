package ast.node.statement;

import ast.Visitor;

import java.util.ArrayList;

public class Block extends Statement {
    private ArrayList<Statement> body = new ArrayList<>();

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void addStatement(Statement statement) {
        this.body.add(statement);
    }

    @Override
    public String toString() {
        return "Block";
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
