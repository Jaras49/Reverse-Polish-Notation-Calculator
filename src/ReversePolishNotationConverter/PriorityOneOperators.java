package ReversePolishNotationConverter;

public class PriorityOneOperators implements OperatorChecker
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
