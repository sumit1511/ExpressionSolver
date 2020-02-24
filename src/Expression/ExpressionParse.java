package Expression;

import ExpressionTree.ExpressionNode;
import ExpressionTree.Tokenizer;
import Operater.Precedence;
import Operater.SineOperands;
import Exception.*;
import Operater.*;
import java.util.List;

public class ExpressionParse
{
     private String Expression;
     private List<ExpressionNode> ExpressionNodeList;
     ExpressionParse(String Expression)
     {
         this.Expression=Expression;
     }
     public List<ExpressionNode> ParsedList() throws ExpressionException
     {
         Precedence precedence = new Precedence();
         try {
             ExpressionNodeList = new Tokenizer(precedence, Expression).CreateExpressionNodeList();
             ExpressionNodeList = new SineOperands(ExpressionNodeList).updateList();
         }
         catch (ExpressionException e)
         {
             throw new ExpressionException(e.getMessage());
         }
         return ExpressionNodeList;
     }

}
