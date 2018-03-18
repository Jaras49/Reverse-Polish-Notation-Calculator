package com.calculator;

import com.calculator.operations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotationCalculator implements Calculator {

    private List<TwoArgumentOperation> operations;

    public ReversePolishNotationCalculator()
    {
        operations = new ArrayList<>();
        operations.add(new AdditionOperation());
        operations.add(new DivisionOperation());
        operations.add(new MultiplicationOperation());
        operations.add(new SubtractionOperation());
    }

    @Override
    public double calculate(String expression)
    {
        Stack<String> stack = new Stack<>();
        String[] operators = expression.split(" ");

        for (String operator : operators )
        {
            double x;
            double y;

            TwoArgumentOperation twoArgumentOperation = getOperation(operator);
            if (twoArgumentOperation != null)
            {
                x = Double.parseDouble(stack.pop());
                y = Double.parseDouble(stack.pop());
                stack.push(Double.toString(twoArgumentOperation.compute(x, y)));
            }
            else
                stack.push(operator);
        }
        return Double.parseDouble(stack.pop());
    }
    private TwoArgumentOperation getOperation(String operator)
    {
        for (TwoArgumentOperation operation : operations)
        {
            if (operation.supports(operator))
            {
                return operation;
            }
        }
        return null;
    }
}