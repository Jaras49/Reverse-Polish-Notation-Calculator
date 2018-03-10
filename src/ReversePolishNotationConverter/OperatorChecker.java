package ReversePolishNotationConverter;

import java.util.Stack;

interface OperatorChecker
{
    boolean isOperator(String operator);
    int getPriority();
    Stack<String> process(Stack<String> stack, String operator);
    String getOut();
}
