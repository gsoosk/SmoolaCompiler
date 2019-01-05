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
import main.ast.node.expression.*;
import main.ast.node.expression.BinaryExpression.BinaryOperator;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.ast.node.expression.Value.StringValue;
import main.ast.node.expression.UnaryExpression.UnaryOperator;
import main.ast.node.statement.*;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class CodeGenerator {
    private static final String stackSize = "1000";
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
    private static String getLabel(int l)
    {
        return "Label" + Integer.toString(l);
    }
    public static String generateCode(ClassDeclaration classDeclaration)
    {
        //TODO : handle inherit
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
            code += "\n   ; " + statement.toString() + "\n" +
                    statement.getCode();
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
        code += newArray.getExpression().getCode();
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
                        Integer.toString(TypeChecker.identifierVariableIndex((Identifier)assign.getlValue()));
            else if(lvalueType instanceof IntType || lvalueType instanceof BooleanType)
                code += "   istore " +
                        Integer.toString(TypeChecker.identifierVariableIndex((Identifier)assign.getlValue()));
        }
        else if(assign.getlValue() instanceof ArrayCall)
        {
            /*
                [arrayCall]
                [value]
                iastore
             */

            code += ((ArrayCall) assign.getlValue()).getInstance().getCode();
            code += ((ArrayCall) assign.getlValue()).getIndex().getCode();
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
            code += "   iload " + //TODO : method is diffrenet
                    Integer.toString(TypeChecker.identifierVariableIndex(identifier));
        code += "\n";
        identifier.setCode(code);
        return code;
    }
    public static String generateCode(ArrayCall arrayCall)
    {
        String code = "";
        code += arrayCall.getInstance().getCode();
        code += arrayCall.getIndex().getCode();
        code += "   iaload\n";

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
        else if(op == BinaryOperator.div)
            code += "   idiv\n";
        else if(op == BinaryOperator.eq || op == BinaryOperator.neq || op == BinaryOperator.gt || op == BinaryOperator.lt)
        {
            if(binaryExpression.getLeft().getType() instanceof IntType || binaryExpression.getLeft().getType() instanceof BooleanType)
            {
                String cond = "";
                if(op == BinaryOperator.eq)
                    cond = "   if_icmpne ";
                else if(op == BinaryOperator.neq)
                    cond = "   if_icmpeq ";
                else if (op == BinaryOperator.gt)
                    cond = "   if_icmple ";
                else if(op == BinaryOperator.lt)
                    cond = "   if_icmpge ";

                code += cond +
                        getLabel(label)+ "\n" +
                        "   iconst_1" + "\n" +
                        "   goto " + getLabel(label + 1) + "\n" +
                        getLabel(label) + ":\n" +
                        "   iconst_0" + "\n" +
                        getLabel(label + 1) + ":\n";
                label += 2;
            }
            else if(binaryExpression.getLeft().getType() instanceof StringType)
            {
                code += "   invokevirtual java/lang/String.equals(Ljava/lang/Object;)Z\n";
            }
            else
            {
                code += "   invokevirtual java/lang/Object.equals(Ljava/lang/Object;)Z\n";
            }

        }
        else if(op == BinaryOperator.and || op == BinaryOperator.or)
        {
            String cond = op == BinaryOperator.and ? "   ifeq " : "   ifne ";
            String const1 = op == BinaryOperator.and ? "   iconst_1\n" : "   iconst_0\n";
            String const2 = op == BinaryOperator.and ? "   iconst_0\n" : "   iconst_1\n";
            int label1 = label++;
            int label2 = label++;
            code = "";
            code += binaryExpression.getLeft().getCode();
            code += cond + getLabel(label1) + "\n";
            code += binaryExpression.getRight().getCode();
            code += cond + getLabel(label1) + "\n" +
                    const1 +
                    "   goto " + getLabel(label2) + "\n" +
                    getLabel(label1) +":\n" +
                    const2+
                    getLabel(label2) + ":\n";

        }
        binaryExpression.setCode(code);
        return code;
    }
    public static String generateCode(UnaryExpression unaryExpression)
    {
        String code = "";
        code += unaryExpression.getValue().getCode();
        if(unaryExpression.getUnaryOperator() == UnaryOperator.not)
        {
            int label1 = label++;
            int label2 = label++;
            code += "   ifne " + getLabel(label1) + "\n" +
                    "   iconst_1\n" +
                    "   goto " + getLabel(label2) + "\n" +
                    getLabel(label1) + ":\n" +
                    "   iconst_0\n" +
                    getLabel(label2) + ":\n";
        }
        else if(unaryExpression.getUnaryOperator() == UnaryOperator.minus)
            code += "   ineg\n";
        unaryExpression.setCode(code);
        return code;
    }
    public static String generateCode(While loop)
    {
        /*
            CHECK_COND :
                [cond]
                ifeq END
                [statement]
                goto CHECK_COND
            END :
         */
        int labelCond = label++;
        int labelEnd = label++;
        String code = getLabel(labelCond) + ":\n";
        code += loop.getCondition().getCode() +
                "   ifeq " + getLabel(labelEnd  ) + "\n";
        code += loop.getBody().getCode();
        code += "   goto " + getLabel(labelCond) + " \n" +
                getLabel(labelEnd) + ":\n";


        loop.setCode(code);
        return code;
    }
    public static String generateCode(BooleanValue value)
    {
        String code = "";
        if(value.isConstant())
            code += "   iconst_1\n";
        else
            code += "   iconst_0\n";
        value.setCode(code);
        return code;
    }
    public static String generateCode(Block block)
    {
        String code = "";
        ArrayList<Statement> body =  block.getBody();
        for (Statement aBody : body) {
            code += aBody.getCode();
        }
        block.setCode(code);
        return code;
    }
    public static String generateCode(Conditional conditional)
    {
        /*
                [condition]
                ifeq ELSE
                [consequenceBody]
                goto END
          ELSE:
                [alternativeBody]?
          END:

         */
        int elseLabel = label++;
        int endLabel = label++;
        String code = "";
        code += conditional.getExpression().getCode();
        code += "   ifeq " + getLabel(elseLabel) + "\n";
        code += conditional.getConsequenceBody().getCode();
        code += "   goto " + getLabel(endLabel) + "\n" +
                getLabel(elseLabel) + ":\n" ;
        if(conditional.getAlternativeBody() != null)
            code += conditional.getAlternativeBody().getCode();
        code += getLabel(endLabel) + ":\n";

        conditional.setCode(code);
        return code;
    }
    public static String generateCode(Length length)
    {
        String code = "";
        code += length.getExpression().getCode();
        code += "   arraylength \n";
        length.setCode(code);
        return code;
    }
    public static String generateCode(NewClass newClass)
    {
        String code = "";
        code += "   new " + newClass.getClassName().getName() + "\n";
        code += "   dup\n" + // For invoking constructor
                "   invokespecial  "+ newClass.getClassName().getName()+"/<init>()V\n";
        newClass.setCode(code);
        return code;
    }
    public static String generateCode(This instance)
    {
        String code = "   aload_0\n";
        instance.setCode(code);
        return code;
    }
    public static String generateCode(MethodCall methodCall)
    {
        /*
            [instance]
            [arg]*
            invokevirtual
         */
        String code = "";
        code += methodCall.getInstance().getCode();

        ArrayList<Expression> args = methodCall.getArgs();
        for (Expression arg : args) {
            code += arg.getCode();
        }

        String methodName = "";//TODO
        code += "   invokevirtual " + methodName + "\n";

        methodCall.setCode(code);
        return code;
    }

}
