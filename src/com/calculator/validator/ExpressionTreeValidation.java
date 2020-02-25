package com.calculator.validator;
import com.calculator.expressiontree.ExpressionNode;
public class ExpressionTreeValidation {
    private ExpressionNode expressionRoot;
    public ExpressionTreeValidation(ExpressionNode expressionRoot)
    {
        this.expressionRoot =expressionRoot;
    }
    public boolean ExpressionValidator(ExpressionNode expressionRoot)
    {
        if(expressionRoot==null)
        {
            return false;
        }
       if(expressionRoot!=null)
       {
           if(expressionRoot.type=="binary")
           {
               if(expressionRoot.left==null || expressionRoot.right==null)
               {
                   return false;
               }
           }
           else if(expressionRoot.type=="unary")
           {
               if(expressionRoot.right==null)
               {
                   return false;
               }
           }
           else
           {
               if(expressionRoot.left!=null || expressionRoot.right!=null)
               {
                   return false;
               }
           }
       }
       if(expressionRoot.left!=null)
       {
           ExpressionValidator(expressionRoot.left);
       }
       if(expressionRoot.right!=null)
       {
           ExpressionValidator(expressionRoot.right);
       }
        return true;
    }

}
