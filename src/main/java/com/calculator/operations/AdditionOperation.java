package com.calculator.operations;

public class AdditionOperation implements TwoArgumentOperation
{
    @Override
    public double compute(double x, double y)
    {
        return y + x;
    }
    @Override
    public boolean supports(String operator)
    {
        return "+".equals(operator);
    }
}
