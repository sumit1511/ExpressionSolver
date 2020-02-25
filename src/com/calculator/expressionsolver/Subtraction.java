package com.calculator.expressionsolver;

public class Subtraction extends MainSolver {
    public Subtraction()
    {
        super();
    }
    public double expressionEvaluate(int signed,double ...exp1)
    {
        return exp1[0]-exp1[1];
    }
}
