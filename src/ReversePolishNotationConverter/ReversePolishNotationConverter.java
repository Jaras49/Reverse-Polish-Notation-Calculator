package ReversePolishNotationConverter;

import java.util.Stack;

public class ReversePolishNotationConverter implements Converter {
    private String out = "";
    private Stack<String> stack = new Stack();
    private String[] operators;

    @Override
    public String convert(String expression) {
        this.operators = expression.split(" ");

        for (String operator : operators)
        {
            if(operator.equals("-") || operator.equals("+") || operator.equals("*") || operator.equals("/"))
            {
                if(stack.empty())
                {
                    stack.push(operator);
                }
                else
                {
                    out = out + " " + getOperatorsWithPriorityLowerOrEqual(operator);
                    stack.push(operator);
                }
            }
            else
            {
                out = out + " " + operator;
            }
        }

        return out + " " + getRestFromStack();
    }
    private int getPriority(String operator)
    {
        if (operator.equals("+") || operator.equals("-"))
        {
            return 1;
        }
        else if (operator.equals("*") || operator.equals("/"))
        {
            return 2;
        }
        return 0;
    }
    private String getOperatorsWithPriorityLowerOrEqual(String operator)
    {
        String result = "";
        while (!stack.empty())
        {
            if (getPriority(operator) <= getPriority(stack.peek()))
            {
                result = result + " " + stack.pop();
            }
            else
            {
                break;
            }
        }
        return result;
    }
    private String getRestFromStack ()
    {
        String result = "";
        while (!stack.empty())
            result = result + " " + stack.pop();

        return result;
    }
}