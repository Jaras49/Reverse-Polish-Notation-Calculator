package com.reversepolishnotationconverter;

import com.reversepolishnotationconverter.operators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

public class ReversePolishNotationConverter implements Converter
{
    private Stack<String> stack;
    private List<Operator> operations;

    public ReversePolishNotationConverter()
    {
        operations = new ArrayList<>();
        operations.add(new PriorityOneOperators());
        operations.add(new PriorityTwoOperators());
        operations.add(new LeftBracket());
        operations.add(new RightBracket());
    }
    @Override
    public String convert(String expression)
    {
        StringJoiner stringJoiner = new StringJoiner(" ");
        stack = new Stack<>();
        String[] operators;

        operators = expression.split(" ");

        for (String operator : operators)
        {
            Operator oc = getOperation(operator);
            if(oc != null && oc.isOperator(operator))      // When operator
            {
               stack = oc.process(stack, operator);
               if (oc.getOut() != null)
               stringJoiner.merge(oc.getOut());
            }
            else                                          // When number
            {
                stringJoiner.add(operator);
            }
        }
        return stringJoiner.merge(getRestFromStack()).toString();
    }
    private StringJoiner getRestFromStack ()
    {
        StringJoiner stringJoiner = new StringJoiner(" ");
        while (!stack.empty())
            stringJoiner.add(stack.pop());

        return stringJoiner;
    }
    public Operator getOperation(String operator)
    {
        for (Operator operation : operations)
        {
            if (operation.isOperator(operator))
                return operation;
        }
        return null;
    }
}