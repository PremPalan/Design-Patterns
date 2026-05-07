package com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<Character, Integer> variables = new HashMap<>();

    public void setVariables(Character c, Integer x){
        variables.put(c,x);
    }

    public Integer getVariables(Character c){
        return variables.get(c);
    }

}
