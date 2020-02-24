package ExpressionTree;

import ExpressionTree.ExpressionNode;
import Operater.Precedence;
import Exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class Tokenizer
{

    private String Expression;
    private List<ExpressionNode>ExpressionNodeList=new ArrayList<ExpressionNode>();
    private  Precedence precedence;
    public Tokenizer(Precedence precedence, String Expression)
    {
        this.Expression=Expression;
        this.precedence=precedence;
    }
    ExpressionNode newNode(String ExpPart,int TokenPrecedence)
    {
        return new ExpressionNode(ExpPart,TokenPrecedence);
    }
    public List<ExpressionNode> CreateExpressionNodeList() throws ExpressionException
    {
         int i=0;
         String token="";
         int flag=0;
         while(i<Expression.length())
         {

             if((Expression.charAt(i)>='0' && Expression.charAt(i)<='9')||Expression.charAt(i)=='.')
             {
                     if(token.length()==0 || ((token.charAt(0)>='0' && token.charAt(0)<='9')))
                     {
                         token = token + Expression.charAt(i);
                         if(Expression.charAt(i)=='.')
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
                             token=""+Expression.charAt(i);
                             ExpressionNodeList.add(tokenNode);
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
                     token=""+Expression.charAt(i);
                     ExpressionNodeList.add(tokenNode);
                 }
                 else
                 {
                     token=token+Expression.charAt(i);
                 }

             }

             i++;

         }
        int tokenPrecedence=precedence.isValidToken(token);
        if(tokenPrecedence!=-1)
        {
            ExpressionNode tokenNode=newNode(token,tokenPrecedence);
            ExpressionNodeList.add(tokenNode);
        }
        return ExpressionNodeList;
    }

}
