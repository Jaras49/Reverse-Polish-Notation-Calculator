package com.calculator;

import java.util.ArrayDeque;

public class ReversePolishNotationCalculator implements Calculator {

    @Override
    public double calculate(String expression) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] operators = expression.split(" ");


        for (String operator : operators ){
            double temp = 0;
            double x;
            double y;

            if(operator.equals("-") || operator.equals("+") ||
                    operator.equals("/") || operator.equals("*")){

                x = Double.parseDouble(stack.pop());
                y = Double.parseDouble(stack.pop());

                switch (operator){
                    case "+":
                        temp = y + x;
                        break;
                    case "-":
                        temp = y - x;
                        break;
                    case "*":
                        temp = y * x;
                        break;
                    case "/":
                        temp = y / x;
                        break;
                }
                stack.push(Double.toString(temp));
            }
            else
                stack.push(operator);
        }
        return Double.parseDouble(stack.pop());
    }
}