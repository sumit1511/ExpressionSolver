package Operater;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import ExpressionTree.ExpressionNode;
public class SineOperands
{
    List<ExpressionNode>ExpressionNodeList;
    public SineOperands(List<ExpressionNode> ExpressionNodeList)
    {
        this.ExpressionNodeList=ExpressionNodeList;
    }
    public List<ExpressionNode> updateList()
    {
        // handle sine operands
        updateMulipelBinaryOperater();
        return ExpressionNodeList;
    }
    public void updateMulipelBinaryOperater()
    {
        String check="";
        String regexSing="[+|\\-|*|/|(][+|-]";
        String updateNext="";
        ListIterator<ExpressionNode>
                iterator = ExpressionNodeList.listIterator();
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
            else if(((exp.Precedence>=1 && exp.Precedence<=2)|| (check.length()==0 && exp.Precedence==6)) && check.length()<=2)
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
            if(exp.Precedence==6)
            {
                check="(";
            }
        }
    }
}
