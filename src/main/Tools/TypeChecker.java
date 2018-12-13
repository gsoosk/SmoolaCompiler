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

import java.util.ArrayList;

/**
 * TypeChecker
 */
public class TypeChecker {

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
      if(!(expressionTypeCheck(expr.getLeft()).equals(expressionTypeCheck(expr.getRight())) ) )
      {
        return new NoType();
      }
      return new OkType();
    }
    return toReturn;
  }
  public static Type identifierTypeCheck(Expression expr)
  {
    Type toReturn = new NoType();
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
      expr.setType(identifierTypeCheck(expr));
    else
      expr.setType(new NoType());
    return expr.getType();
  }

  // public static boolean checkWriteArgument() {

  // }
}