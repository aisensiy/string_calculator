package com.github.string.calculator;

import org.junit.Test;

import static com.github.string.calculator.StringCalculator.sum;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
    @Test
    public void should_return_0_for_null() {
        assertThat(sum(null), is(0));
    }

    @Test
    public void should_return_0_for_empty() {
        assertThat(sum(""), is(0));
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

    @Test
    public void should_return_sum_of_unknown_numbers_of_values() {
        assertThat(sum("1,1,1"), is(3));
    }

    @Test
    public void should_support_new_line() {
        assertThat(sum("1\n2,3"), is(6));
    }

    @Test
    public void should_support_customzied_demilitor() {
        assertThat(sum("//;\n1;2"), is(3));
        assertThat(sum("//;\n1;5"), is(6));
        assertThat(sum("//%\n1%5"), is(6));
    }

    @Test(expected = RuntimeException.class)
    public void should_raise_exception_with_negative_number() {
        sum("-1");
    }

    @Test(expected = RuntimeException.class)
    public void should_raise_exception_with_negative_number2() {
        sum("1,-1");
    }

    @Test
    public void should_get_value_with_dash() {
        assertThat(sum("//-\n1-5"), is(6));
    }

    @Test
    public void should_get_2_given_2_1001() {
        assertThat(sum("2,1001"), is(2));
    }

    @Test
    public void should_support_customized_string_splitter() {
        assertThat(sum("//[xxx]\n1xxx2xxx3"), is(6));
        assertThat(sum("//[aaaa]\n1aaaa2aaaa3"), is(6));
    }

    @Test
    public void should_support_multi_customized_splitter() {
        assertThat(sum("//[*][%]\n1*2%3"), is(6));
    }
}