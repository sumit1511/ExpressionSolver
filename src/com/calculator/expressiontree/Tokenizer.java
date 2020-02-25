package com.calculator.expressiontree;
import com.calculator.operator.Precedence;
import com.calculator.exception.ExpressionException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class Tokenizer
{

    private String expression;
    private List<ExpressionNode> expressionNodeList =new ArrayList<ExpressionNode>();
    private  Precedence precedence;
    public Tokenizer(Precedence precedence, String expression)
    {
        this.expression =expression;
        this.precedence=precedence;
    }
    ExpressionNode newNode(String ExpPart,int TokenPrecedence)
    {
        return new ExpressionNode(ExpPart,TokenPrecedence);
    }
    public List<ExpressionNode> createExpressionNodeList() throws ExpressionException
    {
         int i=0;
         String token="";
         int flag=0;
         while(i< expression.length())
         {

             if((expression.charAt(i)>='0' && expression.charAt(i)<='9')|| expression.charAt(i)=='.')
             {
                     if(token.length()==0 || ((token.charAt(0)>='0' && token.charAt(0)<='9')))
                     {
                         token = token + expression.charAt(i);
                         if(expression.charAt(i)=='.')
                         {
                             flag++;
                         }
                         if(flag==2 && Pattern.matches("[0-9]+(\\.?[0-9]+?)?",token)==false)
                         {
                             throw  new ExpressionException(token);
                         }
                     }
                    else
                     {

                         int tokenPrecedence=precedence.isValidToken(token);
                         if(tokenPrecedence!=-1)
                         {
                             ExpressionNode tokenNode=newNode(token,tokenPrecedence);
                             token=""+ expression.charAt(i);
                             expressionNodeList.add(tokenNode);
                             flag=0;
                         }
                         else
                         {
                             //exception
                             throw  new ExpressionException(token);

                         }
                     }

             }
             else
             {

                 int tokenPrecedence=precedence.isValidToken(token);
                 if(tokenPrecedence!=-1)
                 {
                     ExpressionNode tokenNode=newNode(token,tokenPrecedence);
                     token=""+ expression.charAt(i);
                     expressionNodeList.add(tokenNode);
                 }
                 else
                 {
                     token=token+ expression.charAt(i);
                 }

             }

             i++;

         }
        int tokenPrecedence=precedence.isValidToken(token);
        if(tokenPrecedence!=-1)
        {
            ExpressionNode tokenNode=newNode(token,tokenPrecedence);
            expressionNodeList.add(tokenNode);
        }
        return expressionNodeList;
    }

}
