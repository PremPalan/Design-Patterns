package com.ram.Interpreter.example;

//Context
class Context{

}

//Expression
interface Expression{
    int interpret(Context context);
}

// Terminal Expression
class NumberExpression implements Expression{
    private final int number;

    public NumberExpression(int number){
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

// Non-Terminal Expression
class AdditionExpression implements Expression{
    private final Expression left;
    private final Expression right;

    public AdditionExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

class MultiplicationExpression implements Expression{
    private final Expression left;
    private final Expression right;

    public MultiplicationExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}


class Interpreter{
    private Context context;

    public Interpreter(Context context){
        this.context = context;
    }

    public int interpret(String expression){
        // Parse expression and create expression tree
        Expression expressionTree = buildExpressionTree(expression);

        // Interpret expression tree
        return expressionTree.interpret(context);
    }

    private Expression buildExpressionTree(String expression) {
        // Logic to parse expression and create expression tree
        // For simplicity, assume the expression is already parsed
        // and represented as an expression tree
        return new AdditionExpression(
                new NumberExpression(2),
                new MultiplicationExpression(
                        new NumberExpression(3),
                        new NumberExpression(4)
                )
        );
    }
}

public class Main {
    // main is the client here
    public static void main(String[] args) {

        // input expression
        String expression = "2 + 3 * 4";

        // create interpreter
        Context context = new Context();
        Interpreter interpreter = new Interpreter(context);

        // interpret expression
        int result = interpreter.interpret(expression);
        System.out.println("Result : " + result);
    }
}
