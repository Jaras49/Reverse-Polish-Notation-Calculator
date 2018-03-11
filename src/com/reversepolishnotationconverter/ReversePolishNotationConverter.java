package com.reversepolishnotationconverter;

import com.reversepolishnotationconverter.operators.Operator;
import com.reversepolishnotationconverter.operators.PriorityOneOperators;
import com.reversepolishnotationconverter.operators.PriorityTwoOperators;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotationConverter implements Converter
{
    private Stack<String> stack;
    private List<Operator> operations;

    public ReversePolishNotationConverter()
    {
        operations = new ArrayList<>();
        operations.add(new PriorityOneOperators());
        operations.add(new PriorityTwoOperators());
    }
    @Override
    public String convert(String expression)
    {
        String out = "";
        stack = new Stack<>();
        String[] operators;

        operators = expression.split(" ");

        for (String operator : operators)
        {
            Operator oc = getOperation(operator);
            if(oc != null && oc.isOperator(operator))      // When operator
            {
               stack = oc.process(stack, operator);
               out = out + " " + oc.getOut();
            }
            else                                          // When number
            {
                out = out + " " + operator;
            }
        }
        return out + " " + getRestFromStack();
    }
    private String getRestFromStack ()
    {
        String result = "";
        while (!stack.empty())
            result = result + " " + stack.pop();

        return result;
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