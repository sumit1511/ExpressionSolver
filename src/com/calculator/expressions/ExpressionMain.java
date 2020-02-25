package com.calculator.expressions;
import com.calculator.expressiontree.CreateExpressionTree;
import com.calculator.expressiontree.ExpressionNode;
import com.calculator.validator.ExpressionTreeValidation;
import com.calculator.exception.ExpressionException;
import java.util.List;
import java.util.Scanner;
public class ExpressionMain
{
    public static void main(String[] args)
    {
        while(true) {
            String expression;
            Scanner scan = new Scanner(System.in);
            expression = scan.next();
            try {
                List<ExpressionNode> expressionNodeList = new ExpressionParse(expression).parsedList();
                ExpressionNode expressionRoot = new CreateExpressionTree(expressionNodeList).treeExpression();
                inOrder(expressionRoot);
                System.out.println("");
                boolean expressionValid = new ExpressionTreeValidation(expressionRoot).ExpressionValidator(expressionRoot);
                if (expressionValid==true) {
                    System.out.println(new ExpressionSolution().expressionSolver(expressionRoot));
                }
            } catch (ExpressionException e) {
                System.out.println(e.getMessage() + "  symbol is not valid");
            }
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
