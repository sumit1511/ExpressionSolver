package com.calculator.expressionsolver;

public class Log extends MainSolver {
    public Log()
    {
        super();
    }
    public double expressionEvaluate(int signed,double ...exp1)
    {
        return signed*Math.log(exp1[0]);
    }
}
