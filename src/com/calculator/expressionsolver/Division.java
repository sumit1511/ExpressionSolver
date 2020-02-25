package com.calculator.expressionsolver;

public class Division extends MainSolver {
    public Division()
    {
        super();
    }
    public double expressionEvaluate(int signed,double ...exp1)
    {
        return exp1[0]/exp1[1];
    }
}
