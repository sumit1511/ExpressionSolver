package com.calculator.expressionsolver;

public class Sin extends MainSolver {
    public Sin()
    {
        super();
    }
    public double expressionEvaluate(int signed,double ...exp1)
    {
        return signed*Math.sin(exp1[0]);
    }
}
