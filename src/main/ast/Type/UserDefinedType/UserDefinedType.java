package main.ast.Type.UserDefinedType;

import main.ast.Type.Type;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.expression.Identifier;

public class UserDefinedType extends Type {
    private ClassDeclaration classDeclaration;

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    public void setClassDeclaration(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    private Identifier name;

    @Override
    public String toString() {
        return classDeclaration.getName().getName();
    }
}
