package com.reversepolishnotationconverter.operators;

import com.reversepolishnotationconverter.operators.operations.Operations;

import java.util.Stack;

public class LeftBracket extends Operations implements Operator
{
    @Override
    public boolean isOperator(String operator)
    {
        return "(".equals(operator);
    }
    @Override
    public int getPriority()
    {
        return 0;
    }

    @Override
    public Stack<String> process(Stack<String> stack, String operator)
    {
        super.stack = stack;
        super.stack.push(operator);

        return super.stack;
    }
}
