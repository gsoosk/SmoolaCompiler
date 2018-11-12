package main.ast.node;

import main.ast.Visitor;

import java.lang.instrument.ClassDefinition;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private ArrayList<ClassDefinition> classes = new ArrayList<>();
    private ClassDefinition mainClass;

    public ClassDefinition getMainClass() {
        return mainClass;
    }

    public void setMainClass(ClassDefinition mainClass) {
        this.mainClass = mainClass;
    }

    public void addClass(ClassDefinition classDefinition) {
        classes.add(classDefinition);
    }

    public List<ClassDefinition> getClasses() {
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
