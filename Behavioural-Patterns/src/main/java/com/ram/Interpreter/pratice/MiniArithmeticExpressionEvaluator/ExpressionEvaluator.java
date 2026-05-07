package com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator;

import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.NonTerminalExpressions.AddExpression;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.NonTerminalExpressions.MultiplyExpression;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.NonTerminalExpressions.SubtractExpression;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.TerminalExpressions.NumberExpression;
import com.ram.Interpreter.pratice.MiniArithmeticExpressionEvaluator.TerminalExpressions.VariableExpression;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.setVariables('x',3);
        ctx.setVariables('y',8);

        Expression exp =
                new MultiplyExpression(
                        new AddExpression(
                                new VariableExpression('x'),
                                new NumberExpression(5)
                        ),
                        new SubtractExpression(
                                new VariableExpression('y'),
                                new NumberExpression(2)
                        )
                );

        System.out.println(exp.interpret(ctx));
    }
}
