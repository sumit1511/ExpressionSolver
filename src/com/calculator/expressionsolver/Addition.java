package com.calculator.expressionsolver;

public class Addition extends MainSolver {
    public Addition()
    {
        super();
    }
    public double expressionEvaluate(int signed,double ...exp1)
    {
        return exp1[0]+exp1[1];
    }
}
