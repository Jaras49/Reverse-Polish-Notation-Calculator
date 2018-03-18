package com.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReversePolishNotationCalculatorTest {

    ReversePolishNotationCalculator reversePolishNotationCalculator;

    @Before
    public void setUp() throws Exception {
        reversePolishNotationCalculator = new ReversePolishNotationCalculator();
    }

    @Test
    public void calculate() {

        //Given

        //When
        double result1 = reversePolishNotationCalculator.calculate("2 3 + 5 *");
        double result2 = reversePolishNotationCalculator.calculate("2 7 + 3 / 14 3 - 4 * + 2 /");

        //Then
        Assert.assertEquals(25, result1, 0);
        Assert.assertEquals(23.5, result2, 0);
    }
}