package ReversePolishNotationConverter;

interface OperatorChecker
{
    boolean isOperator(String operator);
    int getPriority();
}
