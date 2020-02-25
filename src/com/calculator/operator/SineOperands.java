package com.calculator.operator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import com.calculator.expressiontree.ExpressionNode;
public class SineOperands
{
    List<ExpressionNode> expressionNodeList;
    public SineOperands(List<ExpressionNode> expressionNodeList)
    {
        this.expressionNodeList =expressionNodeList;
    }
    public List<ExpressionNode> updateList()
    {
        // handle sine operands
        updateMultipleBinaryOperator();
        return expressionNodeList;
    }
    public void updateMultipleBinaryOperator()
    {
        String check="";
        String regexSing="[+|\\-|*|/|(][+|-]";
        String updateNext="";
        ListIterator<ExpressionNode>iterator = expressionNodeList.listIterator();
        ExpressionNode sine = iterator.next();
        int flag=0;
        if(sine.value.equals("-"))
        {
            updateNext="-";
            iterator.remove();
            flag=1;
        }
        if(sine.value.equals("+"))
        {
            updateNext="+";
            iterator.remove();
            flag=1;
        }
        if(flag==0) {
            iterator.previous();
        }
        while (iterator.hasNext()) {
            ExpressionNode exp=iterator.next();
            if(updateNext!="")
            {
                exp.value=updateNext+exp.value;
                updateNext="";
            }
            else if(((exp.precedence >=1 && exp.precedence <=2)|| (check.length()==0 && exp.precedence ==6)) && check.length()<=2)
            {

                check+=exp.value;
                if(Pattern.matches(regexSing,check)==true)
                {
                    updateNext=exp.value;
                    iterator.remove();
                }
            }
            else
            {
                check="";
            }
            if(exp.precedence ==6)
            {
                check="(";
            }
        }
    }
}
