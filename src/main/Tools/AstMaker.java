package main.Tools;

import main.ast.Type.PrimitiveType.IntType;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.expression.Expression;
import main.ast.node.expression.Identifier;
import main.ast.node.statement.Statement;

import java.util.ArrayList;

public class AstMaker {
    public static ClassDeclaration mainClass(String mainMethodName , String mainClassName, Expression mainReturnVal,
                    ArrayList<Statement> mainMethodStatements)
    {
        Identifier mainMethodNameId = new Identifier(mainMethodName);
        MethodDeclaration mainMethod = new MethodDeclaration(mainMethodNameId);
        mainMethod.setReturnType(new IntType());
        mainMethod.setReturnValue(mainReturnVal);
        mainMethod.setBody(mainMethodStatements);


        Identifier mainClassNameId = new Identifier(mainClassName);

        ClassDeclaration mainClass = new ClassDeclaration(mainClassNameId, null);
        mainClass.addMethodDeclaration(mainMethod);
        return mainClass;
    }
    public static ClassDeclaration classDeclaration(String name, String parrentName)
    {
        Identifier nameId = new Identifier(name);
        Identifier parrentNameId = new Identifier(parrentName);
        return new ClassDeclaration(nameId, parrentNameId );
    }
}
