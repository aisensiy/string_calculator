package com.github.string.calculator;

import org.junit.Test;

import static com.github.string.calculator.StringCalculator.sum;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
    @Test
    public void should_return_0_for_empty() {
        assertThat(sum("0"), is(0));
    }

    @Test
    public void should_return_same_value_for_single_input() {
        assertThat(sum("1"), is(1));
        assertThat(sum("2"), is(2));
        assertThat(sum("12"), is(12));
    }

    @Test
    public void should_return_sum_of_two_values() {
        assertThat(sum("1,2"), is(3));
        assertThat(sum("1,1"), is(2));
    }
}