package ExpressionTree;

public class ExpressionNode
{
     public ExpressionNode left,right;
     public String value;
     public boolean isOperator;
     public String type;
     public int Precedence;
     ExpressionNode(String ExpPart,int TokenPrecedence)
     {
         this.left=null;
         this.right=null;
         this.value=ExpPart;
         this.Precedence=TokenPrecedence;
         this.isOperator=Operator(value);
         this.type=typeOfOperator();

     }
     boolean Operator(String ExpPart)
     {
         if(Precedence==0)
         {
             return false;
         }
         return true;
     }
     String typeOfOperator()
     {
         if(Precedence==-1)
         {
             return "none";
         }
         else if(Precedence>=1 && Precedence<=2) {
             return "binanry";
         }
         else
         {
            return "uninery";
         }
     }
}
