package com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.TerminalExpressions;

import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.Context;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.Expression;

public class VariableExpression implements Expression {
    private final Character character;

    public VariableExpression(Character character){
        this.character = character;
    }

    @Override
    public Integer interpret(Context context) {
        return context.getVariables(character);
    }
}
