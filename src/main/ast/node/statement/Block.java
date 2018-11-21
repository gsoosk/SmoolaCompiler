package main.ast.node.statement;

import main.ast.Visitor;

import java.util.ArrayList;

public class Block extends Statement {
    private ArrayList<Statement> body = new ArrayList<>();

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void addStatement(Statement statement) {
        this.body.add(statement);
    }
    public void setBody(ArrayList<Statement> allStatements)
    {
        for (int i = 0 ; i < this.body.size() ; i++)
        {
            this.body.add(allStatements.get(i));
        }
    }

    @Override
    public String toString() {
        return "Block";
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
