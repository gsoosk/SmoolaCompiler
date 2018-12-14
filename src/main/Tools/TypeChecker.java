package main.Tools;

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
    if (children.contains(type)) {
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

  private static Type unaryExprTypeCheck(UnaryExpression expr)
  {
    Type toReturn = new NoType();
    if(expr.getUnaryOperator() == UnaryOperator.minus)
    {
      if(!(expressionTypeCheck(expr.getValue()) instanceof IntType))
      {
        return new NoType();
      }

      return new IntType();
    }
    else if(expr.getUnaryOperator() == UnaryOperator.not)
    {
      if(!(expressionTypeCheck(expr.getValue()) instanceof BooleanType))
      {
        return new NoType();
      }
      return new BooleanType();
    }
    return toReturn;
  }
  private static Type binaryExprTypeCheck(BinaryExpression expr)
  {
    Type toReturn = new NoType();
    BinaryOperator operator = expr.getBinaryOperator();
    if( operator == BinaryOperator.add || operator == BinaryOperator.mult ||  operator == BinaryOperator.gt  ||
       operator == BinaryOperator.div || operator == BinaryOperator.sub || operator == BinaryOperator.lt ){
      if(!(expressionTypeCheck(expr.getLeft()) instanceof IntType) || !(expressionTypeCheck(expr.getRight()) instanceof IntType))
      {
        return new NoType();
      }
      if(operator == BinaryOperator.gt  || operator == BinaryOperator.lt)
        return new BooleanType();
      return new IntType();

    }
    else if(operator == BinaryOperator.and || operator == BinaryOperator.or)
    {
      if(!(expressionTypeCheck(expr.getLeft()) instanceof BooleanType) || !(expressionTypeCheck(expr.getRight()) instanceof BooleanType))
      {
        return new NoType();
      }
      return new OkType();
    }
    else if(operator == BinaryOperator.eq || operator == BinaryOperator.neq)
    {
      Type leftType = expressionTypeCheck(expr.getLeft());
      Type rightType = expressionTypeCheck(expr.getRight());
      if(!(leftType.getClass().equals(rightType.getClass())))
      {
        return new NoType();
      }
      if(leftType instanceof NoType || rightType instanceof NoType)
        return new NoType();
      return new BooleanType();
    }
    return toReturn;
  }
  private static Type identifierTypeCheck(Identifier identifier)
  {
    Type toReturn = new NoType();
    if(allClassesSymbolTable.get(currentClassName).getItems().containsKey(identifier.getName()))
    {
       SymbolTableItem item =  allClassesSymbolTable.get(currentClassName).getInCurrentScope(identifier.getName());
       return ((SymbolTableVariableItemBase) item).getType();
    }
    if(allMethodsSymbolTable.get(currentClassName + "-" + currentMethodName).getItems().containsKey(identifier.getName()))
    {
      SymbolTableItem item = allMethodsSymbolTable.get(currentClassName + "-" + currentMethodName).getInCurrentScope(identifier.getName());
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
  private static Type methodCallTypeCheck(MethodCall methodCall)
  {
    //NOTE: This method handle error inside of itself and don't need to handle it outside
    //instace checking
    Type instanceType = expressionTypeCheck(methodCall.getInstance());
    if(!(instanceType instanceof UserDefinedType))
    {
      if(methodCall.getInstance() instanceof Identifier)
        return new NoType("Line:"+ methodCall.getLineNumber() +":class "+ ((Identifier) methodCall.getInstance()).getName() + " is not declared");
      return new NoType("Line:"+ methodCall.getLineNumber() +":"+ methodCall.getInstance().toString() + " is not a class");

    }
    String instanceClassName = ((UserDefinedType)instanceType).getName().getName();
    if(!allClassesSymbolTable.containsKey(instanceClassName))
    {
      return new NoType("Line:"+ methodCall.getLineNumber() +":class "+ instanceClassName + " is not declared");
    }
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
      methodItem = null;
      return new NoType();
    }
    ArrayList<Expression> methodCallArgs = methodCall.getArgs();
    ArrayList<Type> methodItemArgsType = methodItem.getArgTypes();
    if(methodCallArgs.size() != methodItemArgsType.size())
      return new NoType("Line:" + methodCall.getLineNumber() + ":arguments number is not matching to method definition");
    for(int i = 0; i < methodCallArgs.size(); i++)
    {
      expressionTypeCheck(methodCallArgs.get(i));
      if( !methodCallArgs.get(i).getType().getClass().equals(methodItemArgsType.get(i).getClass()))
        return new NoType("Line:" + methodCall.getLineNumber() + ":argument number " + Integer.toString(i) + " does not have correct type");
      if(methodCallArgs.get(i).getType() instanceof UserDefinedType)
      {
        String child = ((UserDefinedType)methodCallArgs.get(i).getType()).getName().getName();
        String parent = ((UserDefinedType) methodItemArgsType.get(i)).getName().getName();
        if(!isSubtypeOf(child, parent))
          return new NoType("Line:" + methodCall.getLineNumber() + ":argument number " + Integer.toString(i) + " does not have correct type");;
      }
    }
    return methodItem.getReturnType();
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
    else
      expr.setType(new NoType());
    return expr.getType();
  }

  // public static boolean checkWriteArgument() {

  // }
}