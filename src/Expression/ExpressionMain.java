package Expression;
import ExpressionTree.CreateExpressionTree;
import ExpressionTree.ExpressionNode;
import Validater.ExpressionTreeValidation;
import Exception.*;
import java.util.List;
import java.util.Scanner;
public class ExpressionMain
{
    public static void main(String[] args) throws ExpressionException
    {
        String Expression;
        Scanner scan = new Scanner(System.in);
        Expression=scan.next();
        try {
            List<ExpressionNode> ExpressionNodeList = new ExpressionParse(Expression).ParsedList();
            ExpressionNode ExpressionRoot=new CreateExpressionTree(ExpressionNodeList).treeExpression();
            inOrder(ExpressionRoot);
            System.out.println("");
            boolean ExpressionValid= new ExpressionTreeValidation(ExpressionRoot).ExpressionValidator(ExpressionRoot);
            if(ExpressionValid==true)
            {
                System.out.println(new ExpressionSolution().expressionSolver(ExpressionRoot));
            }
            else
            {
                //
            }
        }
        catch (ExpressionException e)
        {
            System.out.println(e.getMessage()+"  symbol is not valid");
        }

    }
    public static void inOrder(ExpressionNode exp)
    {
        if(exp.left!=null)
        {
            inOrder(exp.left);
        }
        System.out.print(exp.value+" ");
        if(exp.right!=null)
        {
            inOrder(exp.right);
        }
    }
}
