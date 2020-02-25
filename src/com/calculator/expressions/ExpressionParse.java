package com.calculator.expressions;
import com.calculator.expressiontree.ExpressionNode;
import com.calculator.expressiontree.Tokenizer;
import com.calculator.operator.Precedence;
import com.calculator.operator.SineOperands;
import com.calculator.exception.ExpressionException;
import java.util.List;
public class ExpressionParse
{
     private String expression;
     private List<ExpressionNode> expressionNodeList;
     ExpressionParse(String expression)
     {
         this.expression =expression;
     }
     public List<ExpressionNode> parsedList() throws ExpressionException
     {
             Precedence precedence = new Precedence();
             expressionNodeList = new Tokenizer(precedence, expression).createExpressionNodeList();
             expressionNodeList = new SineOperands(expressionNodeList).updateList();
             return expressionNodeList;
     }
}
