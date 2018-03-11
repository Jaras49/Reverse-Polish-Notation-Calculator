package com.reversepolishnotationconverter.operators;

import java.util.Stack;

public interface OperatorChecker
{
    boolean isOperator(String operator);
    int getPriority();
    Stack<String> process(Stack<String> stack, String operator);
    String getOut();
}
