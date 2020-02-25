package com.calculator.expressionsolver;

public class OperatorInstanceFactory {
    public static MainSolver instanceGenerator(String operator)
    {
        if(operator.equals("+"))
        {
            return new Addition();
        }
        else if(operator.equals("-"))
        {
            return new Subtraction();
        }
        else if(operator.equals("/")==true)
        {
            return new Division();
        }
        else if(operator.equals("*")==true)
        {
            return new Multiplication();
        }
        else if(operator.equals("sin")==true)
        {
            return new Sin();
        }
        else if(operator.equals("cos")==true)
        {
            return new Cos();
        }
        else if(operator.equals("tan")==true)
        {
            return new Tan();
        }
        else if(operator.equals("log")==true)
        {
            return new Log();
        }
        return null;
    }
}
