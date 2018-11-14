package ast.node;

import ast.Visitor;
import java.util.ArrayList;
import ast.node.declaration.ClassDeclaration;
import java.util.List;

public class Program {
    private ArrayList<ClassDeclaration> classes = new ArrayList<>();
    private ClassDeclaration mainClass;

    public ClassDeclaration getMainClass() {
        return mainClass;
    }

    public void setMainClass(ClassDeclaration mainClass) {
        this.mainClass = mainClass;
    }

    public void addClass(ClassDeclaration classDefinition) {
        classes.add(classDefinition);
    }

    public List<ClassDeclaration> getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "Program";
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
