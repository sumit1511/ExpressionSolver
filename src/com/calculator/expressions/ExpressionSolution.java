package com.calculator.expressions;
import com.calculator.expressionsolver.OperatorInstanceFactory;
import com.calculator.expressiontree.ExpressionNode;

public class ExpressionSolution
{

    public double expressionSolver(ExpressionNode expressionRoot)
    {
        if(expressionRoot.isOperator==false)
        {
            return Double.parseDouble(expressionRoot.value);
        }
        else
        {
            if(expressionRoot.type=="binary")
            {
                 return OperatorInstanceFactory.instanceGenerator(expressionRoot.value).expressionEvaluate(0,expressionSolver(expressionRoot.left),expressionSolver(expressionRoot.right));
            }
            else
            {
                  int sine=operandSine(expressionRoot);
                  return OperatorInstanceFactory.instanceGenerator(expressionRoot.value).expressionEvaluate(sine,expressionSolver(expressionRoot.right));
            }
        }
    }
    private int operandSine(ExpressionNode expressionRoot)
    {
        int signed =1;
        if(expressionRoot.value.charAt(0)=='-')
        {
            expressionRoot.value=expressionRoot.value.substring(1,expressionRoot.value.length());
            signed =-1;
        }
        if(expressionRoot.value.charAt(0)=='+')
        {
            expressionRoot.value=expressionRoot.value.substring(1,expressionRoot.value.length());
            signed =1;
        }
        return signed;
    }
}
