package Expression;

import ExpressionTree.ExpressionNode;

public class ExpressionSolution
{
    private double ExpResult;
    public double expressionSolver(ExpressionNode ExpressionRoot)
    {
        if(ExpressionRoot.isOperator==false)
        {
            return Double.parseDouble(ExpressionRoot.value);
        }
        else
        {
            if(ExpressionRoot.type=="binanry")
            {
                if(ExpressionRoot.value.equals("+"))
                {
                    return expressionSolver(ExpressionRoot.left) + expressionSolver(ExpressionRoot.right);
                }
                if(ExpressionRoot.value.equals("-"))
                {
                    return expressionSolver(ExpressionRoot.left) - expressionSolver(ExpressionRoot.right);
                }
                if(ExpressionRoot.value.equals("*"))
                {
                    return expressionSolver(ExpressionRoot.left) * expressionSolver(ExpressionRoot.right);
                }
                if(ExpressionRoot.value.equals("/"))
                {
                    return expressionSolver(ExpressionRoot.left) / expressionSolver(ExpressionRoot.right);
                }

            }
            else
            {
                double sine=1;
                if(ExpressionRoot.value.charAt(0)=='-')
                {
                    ExpressionRoot.value=ExpressionRoot.value.substring(1,ExpressionRoot.value.length());
                    sine=-1;
                }
                if(ExpressionRoot.value.charAt(0)=='+')
                {
                    ExpressionRoot.value=ExpressionRoot.value.substring(1,ExpressionRoot.value.length());
                    sine=1;
                }
                if(ExpressionRoot.value.equals("sin"))
                {

                    return  sine*Math.sin(Math.toRadians(expressionSolver(ExpressionRoot.right)));
                }
                if(ExpressionRoot.value.equals("cos"))
                {
                    return  sine*Math.cos(Math.toRadians(expressionSolver(ExpressionRoot.right)));
                }
                if(ExpressionRoot.value.equals("tan"))
                {
                    return  sine*Math.tan(Math.toRadians(expressionSolver(ExpressionRoot.right)));
                }
                if(ExpressionRoot.value.equals("log"))
                {
                    return  sine*Math.log(expressionSolver(ExpressionRoot.right));
                }
            }
        }
        return ExpResult;
    }

}
