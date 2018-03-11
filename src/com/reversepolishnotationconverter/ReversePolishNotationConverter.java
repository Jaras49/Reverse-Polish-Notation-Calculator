package com.reversepolishnotationconverter;

import com.reversepolishnotationconverter.operators.OperatorChecker;
import com.reversepolishnotationconverter.operators.PriorityOneOperators;
import com.reversepolishnotationconverter.operators.PriorityTwoOperators;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotationConverter implements Converter
{
    private String out = "";
    private Stack<String> stack = new Stack();
    private String[] operators;
    private List<OperatorChecker> operations;

    public ReversePolishNotationConverter()
    {
        operations = new ArrayList<>();
        operations.add(new PriorityOneOperators());
        operations.add(new PriorityTwoOperators());
    }
    @Override
    public String convert(String expression) {
        this.operators = expression.split(" ");

        for (String operator : operators)
        {
            OperatorChecker oc = getOperation(operator);
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
    public OperatorChecker getOperation(String operator)
    {
        for (OperatorChecker operation : operations)
        {
            if (operation.isOperator(operator))
                return operation;
        }
        return null;
    }
}