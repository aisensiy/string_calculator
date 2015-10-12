package com.github.string.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
    @Test
    public void should_return_0_for_empty() {
        assertThat(StringCalculator.sum("0"), is(0));
    }
}