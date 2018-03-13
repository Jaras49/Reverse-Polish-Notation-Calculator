package com.reversepolishnotationconverter.operators.operations;

import com.reversepolishnotationconverter.operators.Operator;
import com.reversepolishnotationconverter.ReversePolishNotationConverter;

import java.util.Stack;
import java.util.StringJoiner;

public abstract class Operations
{
    protected StringJoiner stringJoiner;
    protected Stack<String> stack;

    public Stack<String> process(Stack<String> stack, String operator)
    {
        stringJoiner = new StringJoiner(" ");
        this.stack = stack;

        if (this.stack.empty())
        {
            this.stack.push(operator);
        }
        else
        {
            stringJoiner.merge(getOperatorsWithPriorityLowerOrEqual());
            this.stack.push(operator);
        }

        return this.stack;
    }
    private StringJoiner getOperatorsWithPriorityLowerOrEqual()
    {
        StringJoiner stringJoiner = new StringJoiner(" ");

        while (!stack.empty())
        {
            ReversePolishNotationConverter temp = new ReversePolishNotationConverter();    //TODO <<<< To chyba nie jest dobre rozwiązanie, trzeba to sprawdzić
            Operator oc = temp.getOperation(stack.peek());
            if ( getPriority() <= oc.getPriority() && oc != null)
            {
                stringJoiner.add(stack.pop());
            }
            else
            {
                break;
            }
        }
        return stringJoiner;
    }
    public StringJoiner getOut()
    {
        return this.stringJoiner;
    }
    public abstract int getPriority();
}
