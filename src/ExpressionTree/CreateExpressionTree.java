package ExpressionTree;

import ExpressionTree.ExpressionNode;
import Exception.*;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class CreateExpressionTree
{
      private Stack<ExpressionNode>OperatorStack,OperandStack;
      private List<ExpressionNode> ExpressionNodeList;
      public CreateExpressionTree(List<ExpressionNode> ExpressionNodeList)
      {
          this.ExpressionNodeList=ExpressionNodeList;
      }
      //method for creating full expression tree and return  root node
      public ExpressionNode treeExpression() throws ExpressionException
      {
          OperandStack= new Stack<ExpressionNode>();
          OperatorStack=new Stack<ExpressionNode>();
          ListIterator<ExpressionNode> iterator = ExpressionNodeList.listIterator();
          while (iterator.hasNext())
          {
            ExpressionNode exp=iterator.next();
            if(exp.isOperator==true)
            {

                 if(OperatorStack.empty()==true || (OperatorStack.peek().Precedence==6 && OperatorStack.peek().Precedence!=((-1)*exp.Precedence)))
                 {
                     OperatorStack.push(exp);
                 }
                 else
                 {
                     if(OperatorStack.peek().Precedence<exp.Precedence)
                     {
                         OperatorStack.push(exp);
                     }
                     else
                     {

                         while( OperatorStack.empty()==false &&  OperatorStack.peek().Precedence>=exp.Precedence && OperatorStack.peek().Precedence!=6)
                         {

                             if (OperatorStack.peek().type == "binanry") {
                                 if(OperandStack.size()>1) {
                                     OperatorStack.peek().right = OperandStack.peek();
                                     OperandStack.pop();
                                     OperatorStack.peek().left = OperandStack.peek();
                                     OperandStack.pop();
                                     OperandStack.push(OperatorStack.peek());
                                     OperatorStack.pop();
                                 }
                                 else
                                 {
                                     throw new ExpressionException(OperatorStack.peek().value+" extra");
                                 }
                             } else {
                                 if(OperandStack.size()>0) {
                                     OperatorStack.peek().right = OperandStack.peek();
                                     OperandStack.pop();
                                     OperandStack.push(OperatorStack.peek());
                                     OperatorStack.pop();
                                 }
                                 else
                                 {
                                     throw new ExpressionException(OperatorStack.peek().value+" extra");
                                 }
                             }
                         }
                         if(OperatorStack.empty()==false && OperatorStack.peek().Precedence==((-1)*exp.Precedence))
                         {
                             OperatorStack.pop();
                         }
                         else {
                             OperatorStack.push(exp);
                         }
                     }
                 }
            }
            else
            {

                  OperandStack.push(exp);
            }
          }
          while(OperatorStack.empty()==false)
          {

              if (OperatorStack.peek().type == "binanry") {
                 // System.out.println(OperandStack.size());
                  if(OperandStack.size()>1) {
                      OperatorStack.peek().right = OperandStack.peek();
                      OperandStack.pop();
                      OperatorStack.peek().left = OperandStack.peek();
                      OperandStack.pop();
                      OperandStack.push(OperatorStack.peek());
                      OperatorStack.pop();
                  }
                  else
                  {
                      throw new ExpressionException(OperatorStack.peek().value+" extra");
                  }
              } else {
                  if(OperandStack.size()>0) {
                      OperatorStack.peek().right = OperandStack.peek();
                      OperandStack.pop();
                      OperandStack.push(OperatorStack.peek());
                      OperatorStack.pop();
                  }
                  else
                  {
                      throw new ExpressionException(OperatorStack.peek().value+" extra");
                  }
              }
          }
          if(OperandStack.size()==0)
              throw new ExpressionException("Not present Operand");
          return OperandStack.peek();
      }

}
