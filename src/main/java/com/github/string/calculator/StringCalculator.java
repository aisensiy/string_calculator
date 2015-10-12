package com.github.string.calculator;

public class StringCalculator {
    public static int sum(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.contains(",")) {
            String[] split = input.split(",");
            return Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        }
        return Integer.parseInt(input);
    }
}
