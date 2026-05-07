package com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.NonTerminalExpressions;

import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.BinaryExpression;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.Context;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.Expression;

public class MultiplyExpression extends BinaryExpression implements Expression {

    public MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Integer interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}
