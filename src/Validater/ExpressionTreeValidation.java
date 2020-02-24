package Validater;

import ExpressionTree.ExpressionNode;

public class ExpressionTreeValidation {
    private ExpressionNode ExpressionRoot;
    public ExpressionTreeValidation(ExpressionNode ExpressionRoot)
    {
        this.ExpressionRoot=ExpressionRoot;
    }
    public boolean ExpressionValidator(ExpressionNode ExpressionRoot)
    {
        if(ExpressionRoot==null)
        {
            return false;
        }
       if(ExpressionRoot!=null)
       {
           if(ExpressionRoot.type=="binanry")
           {
               if(ExpressionRoot.left==null || ExpressionRoot.right==null)
               {
                   return false;
               }
           }
           else if(ExpressionRoot.type=="uninery")
           {
               if(ExpressionRoot.right==null)
               {
                   return false;
               }
           }
           else
           {
               if(ExpressionRoot.left!=null || ExpressionRoot.right!=null)
               {
                   return false;
               }
           }
       }
       if(ExpressionRoot.left!=null)
       {
           ExpressionValidator(ExpressionRoot.left);
       }
       if(ExpressionRoot.right!=null)
       {
           ExpressionValidator(ExpressionRoot.right);
       }
        return true;
    }

}
