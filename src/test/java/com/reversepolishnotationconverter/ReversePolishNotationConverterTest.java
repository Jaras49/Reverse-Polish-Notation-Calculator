package com.reversepolishnotationconverter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ReversePolishNotationConverterTest {

    ReversePolishNotationConverter reversePolishNotationConverter;

    @Before
    public void setUp() throws Exception {
        reversePolishNotationConverter = new ReversePolishNotationConverter();
    }

    @Test
    public void testReversePolishNotationConverter() {

        //Given

        //When
        String result1 = reversePolishNotationConverter.convert("( ( 2 + 7 ) / 3 + ( 14 - 3 ) * 4 ) / 2");
        String result2 = reversePolishNotationConverter.convert("( 2 + 3 ) * 5");
        //Then
        Assert.assertEquals("2 7 + 3 / 14 3 - 4 * + 2 /", result1);
        Assert.assertEquals("2 3 + 5 *", result2);
    }
}