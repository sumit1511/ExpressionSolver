package Operater;

public class Operator
{
    //array of operators
     String Operator[]={"+","-","/","*"};
    public boolean isOperator(String exp)
    {
        int i=0;
        while(i<Operator.length)
        {
            if(exp==Operator[i])
            {
                return true;
            }
            i++;
        }
      return false;
    }
}
