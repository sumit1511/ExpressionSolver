package com.calculator.operator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class Precedence {

    public Precedence()
    {
        setPrecedence();
    }
    private Map<String, Integer> precedenceList= new HashMap<>();
    public void setPrecedence()
    {
        precedenceList.put("[+|-]",1);
        precedenceList.put("[*|/]",2);
        precedenceList.put("[0-9]+(\\.[0-9]+?)?",0);
        precedenceList.put("sin|cos|tan|log",5);
        precedenceList.put("[(]",6);
        precedenceList.put("[)]",-6);
    }
    public int isValidToken(String token)
    {
        // iterator map  check is valid .

        Iterator<Map.Entry<String, Integer>> itr = precedenceList.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String, Integer> entry = itr.next();
            if(Pattern.matches(entry.getKey(),token)==true)
            {
                return entry.getValue();
            }
        }
        return -1;
    }

}
