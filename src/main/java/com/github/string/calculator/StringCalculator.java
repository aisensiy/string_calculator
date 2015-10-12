package com.github.string.calculator;

import java.util.Arrays;

public class StringCalculator {
    public static int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).sum();
    }
}
