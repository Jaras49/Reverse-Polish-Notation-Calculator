package com.reversepolishnotationconverter.operators;

import com.reversepolishnotationconverter.operators.operations.Operations;

import java.util.Stack;
import java.util.StringJoiner;

public class RightBracket extends Operations implements Operator
{
    @Override
    public boolean isOperator(String operator)
    {
        return ")".equals(operator);
    }

    @Override
    public int getPriority()
    {
        return 1;
    }

    @Override
    public Stack<String> process(Stack<String> stack, String operator)
    {
        super.stringJoiner = new StringJoiner(" ");
        super.stack = stack;

        while(!super.stack.peek().equals("("))
            super.stringJoiner.add(super.stack.pop());
        super.stack.pop();

        return super.stack;
    }
}
