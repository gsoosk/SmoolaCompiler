package main.ast.node.declaration;

import main.ast.Type.Type;
import main.ast.Visitor;
import main.ast.node.expression.Expression;
import main.ast.node.expression.Identifier;
import main.ast.node.statement.Statement;

import java.util.ArrayList;

public class MethodDeclaration extends Declaration {
    private Identifier name;
    private Type returnType;
    private ArrayList<VarDeclaration> args = new ArrayList<>();

    private ArrayList<VarDeclaration> localVars = new ArrayList<>();
    private ArrayList<Statement> body = new ArrayList<>();
    private Expression returnValue;



    public MethodDeclaration(Identifier name) {
        this.name = name;
    }

    public Expression getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Expression returnValue) {
        this.returnValue = returnValue;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public ArrayList<VarDeclaration> getArgs() {
        return args;
    }

    public void addArg(VarDeclaration arg) {
        this.args.add(arg);
    }

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void setBody(ArrayList<Statement> allStatements) {
        this.body.addAll(allStatements);
    }

    public void addStatement(Statement statement) {
        this.body.add(statement);
    }

    public ArrayList<VarDeclaration> getLocalVars() {
        return localVars;
    }

    public void addLocalVar(VarDeclaration localVar) {
        this.localVars.add(localVar);
    }

    @Override
    public String toString() {
        return "MethodDeclaration";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
