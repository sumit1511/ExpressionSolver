package com.calculator.expressionsolver;

public class Multiplication extends MainSolver
{
    public Multiplication()
    {
        super();
    }
    public double expressionEvaluate(int signed,double ...exp1)
    {
        return exp1[0]*exp1[1];
    }
}
