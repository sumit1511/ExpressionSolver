package com.calculator.expressiontree;

public class ExpressionNode
{
     public ExpressionNode left,right;
     public String value;
     public boolean isOperator;
     public String type;
     public int precedence;
     ExpressionNode(String expPart,int tokenPrecedence)
     {
         this.left=null;
         this.right=null;
         this.value=expPart;
         this.precedence =tokenPrecedence;
         this.isOperator= operator();
         this.type=typeOfOperator();
     }
     boolean operator()
     {
         if(precedence == 0)
         {
             return false;
         }
         return true;
     }
     String typeOfOperator()
     {
         if(precedence ==-1)
         {
             return "none";
         }
         else if(precedence >=1 && precedence <=2) {
             return "binary";
         }
         else
         {
            return "unary";
         }
     }
}
