package main.Tools;

import main.ast.Type.NoType;
import main.ast.Type.PrimitiveType.BooleanType;
import main.ast.Type.PrimitiveType.IntType;
import main.ast.node.expression.Expression;


import main.ast.Type.Type;
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

  public static Type expressionTypeCheck(Expression expr)
  {
    Type toReturn = new NoType();
    if(expr.getType() != null)
      return expr.getType();
    else if(expr instanceof IntValue)
      return new IntType();
    else if(expr instanceof BooleanValue)
      return new BooleanType();
    else if(expr instanceof UnaryExpression)
      return unaryExprTypeCheck((UnaryExpression) expr);
    return toReturn;
  }

  // public static boolean checkWriteArgument() {

  // }
}