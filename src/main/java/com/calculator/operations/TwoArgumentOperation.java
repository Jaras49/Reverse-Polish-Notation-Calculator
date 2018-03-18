package com.calculator.operations;

public interface TwoArgumentOperation
{
    double compute(double x, double y);
    boolean supports(String operator);
}
