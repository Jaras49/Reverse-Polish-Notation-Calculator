package com.reversepolishnotationconverter.operators.operations;

import com.reversepolishnotationconverter.operators.OperatorChecker;
import com.reversepolishnotationconverter.ReversePolishNotationConverter;

import java.util.Stack;

public abstract class Operations
{
    private String out;
    private Stack<String> stack;

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
    private String getOperatorsWithPriorityLowerOrEqual()
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
    public String getOut()
    {
        return out;
    }
    public abstract int getPriority();
}
