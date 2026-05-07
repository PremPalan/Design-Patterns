package com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.TerminalExpressions;


import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.Context;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.Expression;

public class NumberExpression implements Expression {
    private final Integer number;

    public NumberExpression(Integer number){
        this.number = number;
    }

    @Override
    public Integer interpret(Context context) {
        return number;
    }
}
