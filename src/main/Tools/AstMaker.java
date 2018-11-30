package main.Tools;

import main.ast.Type.PrimitiveType.IntType;
import main.ast.Type.Type;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.expression.Expression;
import main.ast.node.expression.Identifier;
import main.ast.node.statement.Statement;
import main.ast.node.declaration.VarDeclaration;


import java.util.ArrayList;

public class AstMaker {
    public static ClassDeclaration mainClass(String mainClassName, String mainMethodName, Expression mainReturnVal,
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
    public static ClassDeclaration classDeclaration(String name, String parentName)
    {
        Identifier parentNameId;
        if(parentName != null) {
            parentNameId = new Identifier(parentName);
        }
        else {
            parentNameId = null;
        }
        Identifier nameId = new Identifier(name);
        return new ClassDeclaration(nameId, parentNameId );
    }
    public static VarDeclaration varDeclaration(Identifier identifier, Type type)
    {
        return new VarDeclaration(identifier, type);
    }
}
