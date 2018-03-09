package ReversePolishNotationConverter;

public class PriorityTwoOperators implements OperatorChecker
{
    @Override
    public boolean isOperator(String operator)
    {
        return "*".equals(operator) || "/".equals(operator);

    }
    @Override
    public int getPriority()
    {
        return 2;
    }
}
