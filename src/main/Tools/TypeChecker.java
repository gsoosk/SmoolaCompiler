package main.Tools;

import com.sun.tools.javac.jvm.Code;
import main.ast.Type.ArrayType.ArrayType;
import main.ast.Type.NoType;
import main.ast.Type.OkType;
import main.ast.Type.PrimitiveType.BooleanType;
import main.ast.Type.PrimitiveType.IntType;
import main.ast.Type.UserDefinedType.UserDefinedType;
import main.ast.node.expression.*;
import main.ast.node.expression.BinaryExpression.BinaryOperator;


import main.ast.Type.Type;
import main.ast.node.expression.UnaryExpression.UnaryOperator;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.symbolTable.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * TypeChecker
 */
public class TypeChecker {

  private static HashMap<String, SymbolTable> allClassesSymbolTable ;
  private static HashMap<String, SymbolTable> allMethodsSymbolTable ;
  private static String currentClassName ;
  private static String currentMethodName;
  public static void setHashesForIdentifier(HashMap<String, SymbolTable> c, HashMap<String, SymbolTable> m)
  {
    allClassesSymbolTable = c;
    allMethodsSymbolTable = m;
  }
  public static void setForIdentifier( String ccN, String cmN)
  {
    currentClassName = ccN;
    currentMethodName = cmN;
  }


  public static boolean isSubtypeOf(String type, String parent) {
    ArrayList<String> children = HashMaker.getClassesTree().get(parent);
    if (type.equals(parent)) {
      return true;
    } else if (children.contains(type)) {
      return true;
    } else {
      boolean contain = false;
      for (String child : children) {
        if (isSubtypeOf(type, child)) {
          contain = true;
          break;
        }
      }
      return contain;
    }
  }
  private static boolean checkSubTyping(String type, String parent)
  {
    if(isSubtypeOf(type, parent))
      return  true;
    return isSubtypeOf(parent, type);
  }
  private static Type unaryExprTypeCheck(UnaryExpression expr)
  {
    Type expressionType =  expressionTypeCheck(expr.getValue());
    if(expr.getUnaryOperator() == UnaryOperator.minus)
    {
      if(expressionType instanceof NoType)
        return new IntType();
      if(!(expressionType instanceof IntType))
        return new NoType();
      return new IntType();
    }
    else if(expr.getUnaryOperator() == UnaryOperator.not)
    {
      if(expressionType instanceof NoType)
        return new BooleanType();
      if(!(expressionType instanceof BooleanType))
        return new NoType();
      return new BooleanType();
    }
    return new NoType();
  }
  private static Type binaryExprTypeCheck(BinaryExpression expr)
  {

    BinaryOperator operator = expr.getBinaryOperator();
    Type leftType = expressionTypeCheck(expr.getLeft());
    Type rightType = expressionTypeCheck(expr.getRight());

    if( operator == BinaryOperator.add || operator == BinaryOperator.mult ||  operator == BinaryOperator.gt  ||
       operator == BinaryOperator.div || operator == BinaryOperator.sub || operator == BinaryOperator.lt ){
      if(!(leftType instanceof IntType) && !(leftType instanceof  NoType))
        return new NoType();
      if(!(rightType instanceof IntType) && !(rightType instanceof  NoType))
        return new NoType();
      if(operator == BinaryOperator.gt  || operator == BinaryOperator.lt)
        return new BooleanType();
      return new IntType();

    }
    else if(operator == BinaryOperator.and || operator == BinaryOperator.or)
    {
      if(!(leftType instanceof BooleanType) && !(leftType instanceof NoType))
        return new NoType();
      if(!(rightType instanceof BooleanType) && !(rightType instanceof NoType))
        return new NoType();

      return new BooleanType();
    }
    else if(operator == BinaryOperator.eq || operator == BinaryOperator.neq)
    {
      if(leftType instanceof ArrayType && rightType instanceof ArrayType)
      {
        if(((ArrayType) leftType).getSize() != ((ArrayType) rightType).getSize())
          return new NoType();
      }
      if(leftType instanceof BooleanType || rightType instanceof BooleanType)
        return new NoType();

      if(leftType instanceof NoType || rightType instanceof NoType)
        return new BooleanType();

      if(!(leftType.getClass().equals(rightType.getClass())) )
        return new NoType();

      if(leftType instanceof UserDefinedType && rightType instanceof UserDefinedType)
      {
        if(!checkSubTyping(((UserDefinedType) leftType).getName().getName(), ((UserDefinedType) rightType).getName().getName()))
          return new NoType();
      }
      return new BooleanType();
    }
    else if(operator == BinaryOperator.assign)
    {
      if(!(expr.getLeft() instanceof Identifier || expr.getLeft() instanceof ArrayCall))
      {
        return new NoType("Line:" + expr.getLeft().getLineNumber() +  ":left side of assignment must be a valid lvalue");
      }
      return expr.getLeft().getType();
    }
    return new NoType();
  }
  private static Type identifierTypeCheck(Identifier identifier)
  {
    Type toReturn = new NoType();
    if(allMethodsSymbolTable.get(currentClassName + "-" + currentMethodName).getItems().containsKey(identifier.getName()))
    {
      SymbolTableItem item = allMethodsSymbolTable.get(currentClassName + "-" + currentMethodName).getInCurrentScope(identifier.getName());
      return ((SymbolTableVariableItemBase) item).getType();
    }
    if(allClassesSymbolTable.get(currentClassName).getItems().containsKey(identifier.getName()))
    {
       SymbolTableItem item =  allClassesSymbolTable.get(currentClassName).getInCurrentScope(identifier.getName());
       return ((SymbolTableVariableItemBase) item).getType();
    }

//    For Static Method support. Smoola doesn't support it!
//    if(allClassesSymbolTable.containsKey(identifier.getName()))
//    {
//      UserDefinedType classType = new UserDefinedType();
//      classType.setName(identifier);
//      return classType;
//    }
    return toReturn;
  }
  public static int identifierVariableIndex(Identifier identifier)
  {
    if(allMethodsSymbolTable.get(currentClassName + "-" + currentMethodName).getItems().containsKey(identifier.getName()))
    {
      try
      {
        SymbolTableItem item = allMethodsSymbolTable.get(currentClassName + "-" + currentMethodName).get(identifier.getName());
        if(item instanceof SymbolTableVariableItemBase)
          return ((SymbolTableVariableItemBase) item).getIndex();
        return -1;
      }
      catch (Exception ex){
        return -1;
      }

    }
    if(allClassesSymbolTable.get(currentClassName).getItems().containsKey(identifier.getName()))
    {
      try
      {
        SymbolTableItem item = allClassesSymbolTable.get(currentClassName).get(identifier.getName());
        if(item instanceof SymbolTableVariableItemBase)
          return ((SymbolTableVariableItemBase) item).getIndex();
        return -1;
      }
      catch (Exception ex){
        return -1;
      }
    }
    return -1;
  }
  private static Type methodCallTypeCheck(MethodCall methodCall)
  {
    //NOTE: This method handle error inside of itself and don't need to handle it outside. just should print NoType error

    //instance checking.
    Type instanceType = expressionTypeCheck(methodCall.getInstance());
    if(instanceType instanceof NoType)
      return new NoType();

    if(!(instanceType instanceof UserDefinedType))
    {
      return new NoType("Line:"+ methodCall.getLineNumber() +":"+ methodCall.getInstance().toString() + " is not a class instance");
    }

    String instanceClassName = ((UserDefinedType)instanceType).getName().getName();
    if(!allClassesSymbolTable.containsKey(instanceClassName))
    {
      return new NoType("Line:"+ methodCall.getLineNumber() +":class "+ instanceClassName + " is not declared");
    }

    //MethodName checking
    String methodName = methodCall.getMethodName().getName();
    if(!allClassesSymbolTable.get(instanceClassName).getItems().containsKey("Method:<"+methodName+">"))
    {
      return new NoType("Line:"+ methodCall.getLineNumber()+":there is no method named "+ methodName +" in class "+ instanceClassName);
    }
    SymbolTableMethodItem methodItem;
    try{
      methodItem =(SymbolTableMethodItem) allClassesSymbolTable.get(instanceClassName).get("Method:<"+methodName+">");

    } catch (ItemNotFoundException e)
    {
      return new NoType();
    }

    ArrayList<Expression> methodCallArgs = methodCall.getArgs();
    ArrayList<Type> methodItemArgsType = methodItem.getArgTypes();
    if(methodCallArgs.size() != methodItemArgsType.size())
      return new NoType("Line:" + methodCall.getLineNumber() + ":arguments number is not matching to method definition");
    for(int i = 0; i < methodCallArgs.size(); i++)
    {
      expressionTypeCheck(methodCallArgs.get(i));
      if(methodCallArgs.get(i).getType() instanceof NoType)
        continue;
      if( !methodCallArgs.get(i).getType().getClass().equals(methodItemArgsType.get(i).getClass()))
        return new NoType("Line:" + methodCall.getLineNumber() + ":argument number " + Integer.toString(i + 1) + " does not have correct type");
      if(methodCallArgs.get(i).getType() instanceof UserDefinedType)
      {
        String child = ((UserDefinedType)methodCallArgs.get(i).getType()).getName().getName();
        String parent = ((UserDefinedType) methodItemArgsType.get(i)).getName().getName();
        if(!isSubtypeOf(child, parent))
          return new NoType("Line:" + methodCall.getLineNumber() + ":argument number " + Integer.toString(i + 1) + " does not have correct type");;
      }
    }
    return methodItem.getReturnType();

  }
  public static String getMethodCallStringRef(MethodCall methodCall)
  {
    String ref = "";
    String instanceClassName = ((UserDefinedType)methodCall.getInstance().getType()).getName().getName();
    String methodName = methodCall.getMethodName().getName();
    String types = "";
    SymbolTableMethodItem methodItem;
    try{
      methodItem =(SymbolTableMethodItem) allClassesSymbolTable.get(instanceClassName).get("Method:<"+methodName+">");

    } catch (ItemNotFoundException e)
    {
      return  "";
    }
    ArrayList<Type> methodItemArgsType = methodItem.getArgTypes();
    for (Type aMethodItemArgsType : methodItemArgsType) {
      types += CodeGenerator.generateCode(aMethodItemArgsType);
    }
    String returnType = CodeGenerator.generateCode(methodItem.getReturnType());
    ref = instanceClassName + "/" + methodName + "(" + types + ")" + returnType;
    return ref;
  }
  private static Type lengthTypeCheck(Length length)
  {
    //instance checking
    Type instanceType = expressionTypeCheck(length.getExpression());
    if(!(instanceType instanceof ArrayType))
    {
      return new NoType("Line:"+ length.getLineNumber() +":"+ "incorrect usage of length");
    }
    return new IntType();
  }
  private static Type arrayCallTypeCheck(ArrayCall arrayCall)
  {
    Type indexType = expressionTypeCheck(arrayCall.getIndex());
    Type instanceType = expressionTypeCheck(arrayCall.getInstance());
    if(!(indexType instanceof NoType) && !(indexType instanceof IntType))
      return new NoType("type of index should be int");
    if(!(instanceType instanceof NoType) && !(instanceType instanceof ArrayType))
      return new NoType("type of instance should be array");

    return new IntType();
  }
  private static Type newArrayTypeCheck(NewArray newArray)
  {
    expressionTypeCheck(newArray.getExpression());
    if(newArray.getExpression().getType() instanceof NoType)
      return new ArrayType();
    if(!(newArray.getExpression().getType() instanceof IntType))
      return new NoType();
    ArrayType toReturn = new ArrayType();
    toReturn.setSize(((IntValue) newArray.getExpression()).getConstant());
    return new ArrayType();
  }
  private static Type newClassTypeCheck(NewClass newClass)
  {
    String className = newClass.getClassName().getName();
    if (!allClassesSymbolTable.containsKey(className)) {
      return new NoType();
    } else {
      Type t = new UserDefinedType();
      ((UserDefinedType)t).setName(newClass.getClassName());
      return t;
    }
  }
  private static Type thisTypeCheck(This instance)
  {
    UserDefinedType toReturn = new UserDefinedType();
    toReturn.setName(new Identifier(currentClassName));
    return toReturn;
  }
  public static Type expressionTypeCheck(Expression expr)
  {

    if(expr.getType() != null)
      return expr.getType();
    else if(expr instanceof IntValue)
      expr.setType(new IntType());
    else if(expr instanceof BooleanValue)
      expr.setType(new BooleanType());
    else if(expr instanceof UnaryExpression)
      expr.setType(unaryExprTypeCheck((UnaryExpression) expr));
    else if(expr instanceof BinaryExpression)
      expr.setType(binaryExprTypeCheck((BinaryExpression) expr));
    else if(expr instanceof Identifier)
      expr.setType(identifierTypeCheck((Identifier) expr));
    else if(expr instanceof MethodCall)
      expr.setType(methodCallTypeCheck((MethodCall) expr));
    else if(expr instanceof Length)
      expr.setType(lengthTypeCheck((Length) expr));
    else if(expr instanceof ArrayCall)
      expr.setType(arrayCallTypeCheck((ArrayCall) expr));
    else if(expr instanceof NewArray)
      expr.setType(newArrayTypeCheck((NewArray) expr));
    else if(expr instanceof NewClass)
      expr.setType(newClassTypeCheck((NewClass) expr));
    else if(expr instanceof This)
      expr.setType(thisTypeCheck((This) expr));
    else
      expr.setType(new NoType());
    return expr.getType();
  }
  
}