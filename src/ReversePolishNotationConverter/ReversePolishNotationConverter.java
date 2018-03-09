package ReversePolishNotationConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotationConverter implements Converter {
    private String out = "";
    private Stack<String> stack = new Stack();
    private String[] operators;
    private List<OperatorChecker> operations;

    public ReversePolishNotationConverter()
    {
        operations = new ArrayList<>();
        OperatorChecker p1 = new PriorityOneOperators();
        OperatorChecker p2 = new PriorityTwoOperators();
        operations.add(p1);
        operations.add(p2);
        //operations.add(new PriorityOneOperators());
        //operations.add(new PriorityTwoOperators());
    }

    @Override
    public String convert(String expression) {
        this.operators = expression.split(" ");

        for (String operator : operators)
        {
            OperatorChecker oc = getOperation(operator);
            if(oc != null && oc.isOperator(operator))
            {
                if(stack.empty())
                {
                    stack.push(operator);
                }
                else
                {
                    out = out + " " + getOperatorsWithPriorityLowerOrEqual(operator,oc.getPriority() );
                    stack.push(operator);
                }
            }
            else
            {
                out = out + " " + operator;
            }
        }

        return out + " " + getRestFromStack();
    }
    private String getOperatorsWithPriorityLowerOrEqual( String operator, int operatorPriority)
    {

        String result = "";
        while (!stack.empty())
        {
            OperatorChecker oc = getOperation(stack.peek());
            if ( operatorPriority <= oc.getPriority() && oc != null)
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
    private String getRestFromStack ()
    {
        String result = "";
        while (!stack.empty())
            result = result + " " + stack.pop();

        return result;
    }
    private OperatorChecker getOperation(String operator)
    {
        for (OperatorChecker operation : operations)
        {
            if (operation.isOperator(operator))
                return operation;
        }
        return null;
    }
}