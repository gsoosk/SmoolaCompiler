package main.Tools;

import main.ast.CodeGenerationVisitor;
import main.ast.Type.ArrayType.ArrayType;
import main.ast.Type.PrimitiveType.BooleanType;
import main.ast.Type.PrimitiveType.IntType;
import main.ast.Type.PrimitiveType.StringType;
import main.ast.Type.Type;
import main.ast.Type.UserDefinedType.UserDefinedType;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.declaration.MethodDeclaration;
import main.ast.node.declaration.VarDeclaration;
import main.ast.node.expression.ArrayCall;
import main.ast.node.expression.BinaryExpression;
import main.ast.node.expression.BinaryExpression.BinaryOperator;
import main.ast.node.expression.Identifier;
import main.ast.node.expression.NewArray;
import main.ast.node.expression.Value.IntValue;
import main.ast.node.expression.Value.StringValue;
import main.ast.node.statement.Assign;
import main.ast.node.statement.Statement;
import main.ast.node.statement.Write;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class CodeGenerator {
    private static final String stackSize = "100";
    private static final String outputPath = "./output/";
    private static int label = 0;
    public static void jasminFileCreator(String code, String className)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath + className + ".j"));

            writer.write(code);
            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static String generateCode(ClassDeclaration classDeclaration)
    {
        String code = ".class public " + classDeclaration.getName().getName() + "\n";
        code += ".super java/lang/Object\n\n";

        ArrayList<VarDeclaration> varDeclarations = classDeclaration.getVarDeclarations();
        for (VarDeclaration varDeclaration : varDeclarations) {
            code += varDeclaration.getCode() + "\n";
        }
        code += "\n";
        code += ".method public <init>()V\n" +
                "   aload_0 ; push this\n" +
                "   invokespecial java/lang/Object/<init>()V ; call super\n" +
                "   return\n" +
                ".end method";

        ArrayList<MethodDeclaration> methodDeclarations = classDeclaration.getMethodDeclarations();
        for (MethodDeclaration methodDeclaration : methodDeclarations) {
            code += "\n\n" + methodDeclaration.getCode() + "\n\n";
        }

        classDeclaration.setCode(code);
        return code;
    }
    public static String generateCode(VarDeclaration varDeclaration)
    {
        String code = ".field protected " + varDeclaration.getIdentifier().getName()
                + " " + generateCode(varDeclaration.getType()) ;

        varDeclaration.setCode(code);
        return code ;
    }
    public static String generateCode(MethodDeclaration methodDeclaration)
    {

        String returnTypeCode = generateCode(methodDeclaration.getReturnType());
        String methodName = methodDeclaration.getName().getName();
        String args = ""; // TODO: ARGS for method
        String staticy = "";
        String returnCode = "";
        switch (returnTypeCode)
        {
            case "I" : returnCode = "   ireturn"; break;
            case "Z" : returnCode = "   ireturn"; break;
            case "Ljava/lang/String;" : returnCode = "  areturn"; break;
            case "[I" : returnCode = "  areturn"; break;
            case "V" : returnCode = "   return"; break;
            case "L" : returnCode = "   areturn"; break;
            default: returnCode = "   return"; break;
        }

        if(CodeGenerationVisitor.inMain)
        {
            returnTypeCode = "V";
            args = "[Ljava/lang/String;";
            staticy = "static ";
            returnCode = "   return";
        }
        String code = ".method public " + staticy + methodName +"("+args+ ")" + returnTypeCode +"\n";
        code += "   .limit stack " + stackSize  +"\n" +
                "   .limit locals "+ stackSize  +"\n";

        ArrayList<Statement> statements = methodDeclaration.getBody();
        for (Statement statement : statements) {
            code += "\n" + statement.getCode() + "\n";
        }

        code += "\n" + methodDeclaration.getReturnValue().getCode() + "\n";

        code += returnCode + "\n";
        code += ".end method\n";

        //TODO : var declarations

        methodDeclaration.setCode(code);
        return code;
    }
    private static String generateCode(Type type)
    {
        String code = "";
        if (type instanceof StringType)
            code = "Ljava/lang/String;";
        else if (type instanceof IntType)
            code = "I";
        else if (type instanceof BooleanType)
            code = "Z";
        else if (type instanceof ArrayType)
            code = "[I";
        else if (type instanceof UserDefinedType)
            code = "L"+((UserDefinedType) type).getName().getName();
        type.setCode(code);
        return code;
    }

    public static String generateCode(Write write)
    {
        String code = "   getstatic java/lang/System/out Ljava/io/PrintStream;\n";

        code += write.getArg().getCode();

        if(write.getArg().getType() instanceof StringType)
            code += "   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";
        else if(write.getArg().getType() instanceof IntType)
            code += "   invokevirtual java/io/PrintStream/println(I)V\n";
        else if(write.getArg().getType() instanceof ArrayType)
            code += "   invokestatic java/util/Arrays.toString([I)Ljava/lang/String;\n" +
                    "   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";

        write.setCode(code);
        return code;
    }
    public static String generateCode(StringValue value)
    {
        String code = "   ldc";
        code += " " + value.getConstant() + "\n";
        value.setCode(code);
        return code;
    }
    public static String generateCode(IntValue value)
    {
        String code = "   ldc";
        code += " " + Integer.toString(value.getConstant()) + "\n";
        value.setCode(code);
        return code;
    }
    public static String generateCode(NewArray newArray)
    {
        String code = "";
        code += newArray.getExpression().getCode() + "\n";
        code += "   newarray int\n";
        newArray.setCode(code);
        return code;
    }
    public static String generateCode(Assign assign)
    {
        String code = "";
        Type lvalueType = assign.getlValue().getType();

        if(assign.getlValue() instanceof Identifier)
        {
            code += assign.getrValue().getCode();

            if(lvalueType instanceof StringType || lvalueType instanceof ArrayType || lvalueType instanceof UserDefinedType)
                code += "   astore " +
                        Integer.toString(TypeChecker.identifierVariableIndex((Identifier)assign.getlValue())) + "\n";
            else if(lvalueType instanceof IntType || lvalueType instanceof BooleanType)
                code += "   istore " +
                        Integer.toString(TypeChecker.identifierVariableIndex((Identifier)assign.getlValue())) + "\n";
        }
        else if(assign.getlValue() instanceof ArrayCall)
        {
            /*
                [arrayCall]
                [value]
                iastore
             */

            code += assign.getlValue().getCode();
            code += assign.getrValue().getCode();
            code += "   iastore";
        }

        code += "\n";
        assign.setCode(code);
        return code;
    }
    public static String generateCode(Identifier identifier)
    {
        String code = "";
        Type type = identifier.getType();
        if(type instanceof ArrayType || type instanceof UserDefinedType || type instanceof StringType)
            code += "   aload " +
                    Integer.toString(TypeChecker.identifierVariableIndex(identifier));
        else if(type instanceof BooleanType || type instanceof IntType)
            code += "   iload " +
                    Integer.toString(TypeChecker.identifierVariableIndex(identifier));
        code += "\n";
        identifier.setCode(code);
        return code;
    }
    public static String generateCode(ArrayCall arrayCall)
    {
        String code = "";
        code += arrayCall.getInstance().getCode();
        code += arrayCall.getIndex().getCode() + "\n";

        arrayCall.setCode(code);
        return code;
    }
    public static String generateCode(BinaryExpression binaryExpression)
    {
        Type type = binaryExpression.getType();

        String code = "";
        code += binaryExpression.getLeft().getCode();
        code += binaryExpression.getRight().getCode();

        BinaryOperator op = binaryExpression.getBinaryOperator();
        if(op == BinaryOperator.add)
            code += "   iadd\n";
        else if(op == BinaryOperator.sub)
            code += "   isub\n";
        else if(op == BinaryOperator.mult)
            code += "   imul\n";
        else if(op == BinaryOperator.eq || op == BinaryOperator.neq)
        {
            if(binaryExpression.getLeft().getType() instanceof IntType || binaryExpression.getLeft().getType() instanceof BooleanType)
            {

                code += (op == BinaryOperator.eq ?  "   if_icmpne " : "   if_icmpeq ")+
                        Integer.toString(label)+ "\n" +
                        "   iconst_1" + "\n" +
                        "   goto " + Integer.toString(label + 1) + "\n" +
                        Integer.toString(label) + ": iconst_0" + "\n" +
                        Integer.toString(label + 1) + ":";
                label += 2;
            }
            else
            {
                //TODO : invoke equals
            }

        }
        //TODO adding other operators
        binaryExpression.setCode(code);
        return code;
    }

}
