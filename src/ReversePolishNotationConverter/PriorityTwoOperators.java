package ReversePolishNotationConverter;

import java.util.Stack;

public class PriorityTwoOperators implements OperatorChecker
{
    private String out;
    private Stack<String> stack;
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
    @Override
    public Stack<String> process(Stack<String> stack, String operator)
    {
        this.out = "";
        this.stack = stack;

        if (this.stack.empty())
        {
            this.stack.push(operator);
        }
        else
        {
            out = out + " " + getOperatorsWithPriorityLowerOrEqual();
            this.stack.push(operator);
        }

        return this.stack;
    }
    private String getOperatorsWithPriorityLowerOrEqual() //TODO gdzieś trzeba wydzielić ten kod dlatego że się powtarza
    {
        String result = "";

        while (!stack.empty())
        {
            ReversePolishNotationConverter temp = new ReversePolishNotationConverter();    //TODO <<<< To chyba nie jest dobre rozwiązanie, trzeba to sprawdzić
            OperatorChecker oc = temp.getOperation(stack.peek());
            if ( getPriority() <= oc.getPriority() && oc != null)
            {
                result = result + " " + stack.pop();
            }
            else
            {
                break;
            }
        }
        return result;
    }

    @Override
    public String getOut()
    {
        return out;
    }
}

