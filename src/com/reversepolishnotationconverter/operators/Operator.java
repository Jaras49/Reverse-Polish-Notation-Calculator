package com.reversepolishnotationconverter.operators;

import java.util.Stack;

public interface Operator
{
    boolean isOperator(String operator);
    int getPriority();
    Stack<String> process(Stack<String> stack, String operator);
    String getOut();
}
