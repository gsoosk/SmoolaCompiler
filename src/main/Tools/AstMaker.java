package main.Tools;

import main.ast.Type.PrimitiveType.IntType;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.expression.Expression;
import main.ast.node.expression.Identifier;
import main.ast.node.statement.Statement;

import java.util.ArrayList;

public class AstMaker {
    public static ClassDeclaration mainClass(Identifier mainMethodName , Identifier mainClassName, Expression mainReturnVal,
                    ArrayList<Statement> mainMethodStatements)
    {
        MethodDeclaration mainMethod = new MethodDeclaration((mainMethodName));
        mainMethod.setReturnType(new IntType());
        mainMethod.setReturnValue(mainReturnVal);
        mainMethod.setBody(mainMethodStatements);

        ClassDeclaration mainClass = new ClassDeclaration(mainMethodName, null);
        mainClass.addMethodDeclaration(mainMethod);
        return mainClass;
    }
}
