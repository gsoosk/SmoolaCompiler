package main.Tools;

import main.ast.Type.NoType;
import main.ast.Type.OkType;
import main.ast.Type.PrimitiveType.BooleanType;
import main.ast.Type.PrimitiveType.IntType;
import main.ast.node.expression.BinaryExpression;
import main.ast.node.expression.BinaryExpression.BinaryOperator;
import main.ast.node.expression.Expression;


import main.ast.Type.Type;
import main.ast.node.expression.Identifier;
import main.ast.node.expression.UnaryExpression;
import main.ast.node.expression.UnaryExpression.UnaryOperator;
import main.ast.node.expression.Value.BooleanValue;
import main.ast.node.expression.Value.IntValue;
import main.symbolTable.ItemAlreadyExistsException;
import main.symbolTable.SymbolTable;
import main.symbolTable.SymbolTableItem;
import main.symbolTable.SymbolTableVariableItemBase;

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
    if(operator == BinaryOperator.gt  || operator == BinaryOperator.add || operator == BinaryOperator.mult ||
       operator == BinaryOperator.div || operator == BinaryOperator.sub || operator == BinaryOperator.lt){
      if(!(expressionTypeCheck(expr.getLeft()) instanceof IntType) || !(expressionTypeCheck(expr.getRight()) instanceof IntType))
      {
        return new NoType();
      }
      return new OkType();
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
    else
      expr.setType(new NoType());
    return expr.getType();
  }

  // public static boolean checkWriteArgument() {

  // }
}