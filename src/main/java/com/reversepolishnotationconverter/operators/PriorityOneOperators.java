package com.reversepolishnotationconverter.operators;

import com.reversepolishnotationconverter.operators.operations.Operations;

public class PriorityOneOperators extends Operations implements Operator
{
    @Override
    public boolean isOperator(String operator)
    {
        return "+".equals(operator) || "-".equals(operator);
    }
    @Override
    public int getPriority()
    {
        return 1;
    }
}
