package com.calculator.expressiontree;
import com.calculator.exception.ExpressionException;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
public class CreateExpressionTree
{
      private Stack<ExpressionNode> operatorStack, operandStack;
      private List<ExpressionNode> expressionNodeList;
      public CreateExpressionTree(List<ExpressionNode> expressionNodeList)
      {
          this.expressionNodeList =expressionNodeList;
      }
      //method for creating full expression tree and return  root node
      public ExpressionNode treeExpression() throws ExpressionException
      {
          operandStack = new Stack<ExpressionNode>();
          operatorStack =new Stack<ExpressionNode>();
          ListIterator<ExpressionNode> iterator = expressionNodeList.listIterator();
          while (iterator.hasNext())
          {
            ExpressionNode exp=iterator.next();
            if(exp.isOperator==true)
            {

                 if(operatorStack.empty()==true || (operatorStack.peek().precedence ==6 && operatorStack.peek().precedence !=((-1)*exp.precedence)))
                 {
                     operatorStack.push(exp);
                 }
                 else
                 {
                     if(operatorStack.peek().precedence <exp.precedence)
                     {
                         operatorStack.push(exp);
                     }
                     else
                     {

                         while( operatorStack.empty()==false &&  operatorStack.peek().precedence >=exp.precedence && operatorStack.peek().precedence !=6)
                         {

                             if (operatorStack.peek().type == "binary") {
                                 if(operandStack.size()>1) {
                                     operatorStack.peek().right = operandStack.peek();
                                     operandStack.pop();
                                     operatorStack.peek().left = operandStack.peek();
                                     operandStack.pop();
                                     operandStack.push(operatorStack.peek());
                                     operatorStack.pop();
                                 }
                                 else
                                 {
                                     throw new ExpressionException(operatorStack.peek().value+" extra");
                                 }
                             } else {
                                 if(operandStack.size()>0) {
                                     operatorStack.peek().right = operandStack.peek();
                                     operandStack.pop();
                                     operandStack.push(operatorStack.peek());
                                     operatorStack.pop();
                                 }
                                 else
                                 {
                                     throw new ExpressionException(operatorStack.peek().value+" extra");
                                 }
                             }
                         }
                         if(operatorStack.empty()==false && operatorStack.peek().precedence ==((-1)*exp.precedence))
                         {
                             operatorStack.pop();
                         }
                         else {
                             operatorStack.push(exp);
                         }
                     }
                 }
            }
            else
            {

                  operandStack.push(exp);
            }
          }
          while(operatorStack.empty()==false)
          {

              if (operatorStack.peek().type == "binary") {
                 // System.out.println(OperandStack.size());
                  if(operandStack.size()>1) {
                      operatorStack.peek().right = operandStack.peek();
                      operandStack.pop();
                      operatorStack.peek().left = operandStack.peek();
                      operandStack.pop();
                      operandStack.push(operatorStack.peek());
                      operatorStack.pop();
                  }
                  else
                  {
                      throw new ExpressionException(operatorStack.peek().value+" extra");
                  }
              } else {
                  if(operandStack.size()>0) {
                      operatorStack.peek().right = operandStack.peek();
                      operandStack.pop();
                      operandStack.push(operatorStack.peek());
                      operatorStack.pop();
                  }
                  else
                  {
                      throw new ExpressionException(operatorStack.peek().value+" extra");
                  }
              }
          }
          if(operandStack.size()==0)
              throw new ExpressionException("Not present Operand");
          return operandStack.peek();
      }

}
