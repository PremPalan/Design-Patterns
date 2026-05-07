package com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.NonTerminalExpressions;

import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.BinaryExpression;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.Context;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.Expression;

public class DivideExpression extends BinaryExpression implements Expression{
    public DivideExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Integer interpret(Context context) {
        return Math.floorDiv(left.interpret(context), right.interpret(context));
    }
}
