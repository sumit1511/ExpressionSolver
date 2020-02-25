package com.calculator.expressionsolver;

public class Cos extends MainSolver {
    public Cos()
    {
        super();
    }
    public double expressionEvaluate(int signed,double ...exp1)
    {
        return signed*Math.cos(exp1[0]);
    }
}
