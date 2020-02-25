package com.calculator.expressionsolver;

public class Tan extends MainSolver {
    public Tan()
    {
        super();
    }
    public double expressionEvaluate(int signed,double ...exp1)
    {
        // Math.tan(Math.toRadians(exp1[0]));
        return signed*Math.tan(exp1[0]);
    }
}
