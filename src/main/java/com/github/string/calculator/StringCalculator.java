package com.github.string.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class StringCalculator {
    public static int sum(String input) {
        //sum(getOperands())

        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (hasCustomizedSplitter(input)) {
            for (String s : getSplitters(getSplitterLine(input))) {
                input = input.substring(input.indexOf('\n') + 1).replace(s, ",");
            }
            return sum(input);
        }

        input = input.replace('\n', ',');
        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).filter(x -> {
            if (x < 0) throw new RuntimeException();
            else return true;
        }).filter(x -> x <= 1000).sum();
    }

    private static boolean hasCustomizedSplitter(String input) {
        return input.startsWith("//");
    }

        private static int sum(List<Integer> operands) {
        return operands.stream().reduce(0, (l, r) -> l + r);
    }

    private static String getSplitterLine(String input) {
        int newLineIndex = input.indexOf('\n');
        return input.substring(0, newLineIndex).substring(2);
    }

    private static List<String> getSplitters(String input) {
        if (input.charAt(0) != '[') {
            return asList(input.substring(0, 1));
        }

        List<String> splitters = new ArrayList<>();
        while (true) {
            String splitter;

            int left = input.indexOf('[');
            int right = input.indexOf(']');
            splitter = input.substring(left + 1, right);

            splitters.add(splitter);
            if (input.length() - 1 == right) {
                break;
            } else {
                input = input.substring(right + 1);
            }
        }

        return splitters;
    }

}
