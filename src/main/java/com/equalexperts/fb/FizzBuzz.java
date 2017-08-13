package com.equalexperts.fb;

import java.util.Map;

import static java.lang.String.valueOf;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Stream.of;

public class FizzBuzz {
    private static final String SPACE = " ";

    public String generateFizzBuzz(int start, int end) {
        validateRange(start, end);

        String fizzBuzzNumbers = rangeClosed(start, end)
                .mapToObj(this::process)
                .reduce("", (accumulator, item) -> accumulator + SPACE + item)
                .trim();
        return generateReport(fizzBuzzNumbers);
    }

    private String generateReport(String fizzBuzzNumbers) {
        Map<String, Long> wordCount =
                of(fizzBuzzNumbers.split(SPACE))
                        .map(this::mapToWordsOrInteger)
                        .collect(groupingBy(identity(), counting()));

         return buildReport(fizzBuzzNumbers, wordCount);
    }

    private String process(int number) {
        if (isNumberContainsThree(number)) {
            return "lucky";
        }
        if (isMultipleOf(number, 15)) {
            return "fizzbuzz";
        }
        if (isMultipleOf(number, 3)) {
            return "fizz";
        }
        if (isMultipleOf(number, 5)) {
            return "buzz";
        }
        return valueOf(number);
    }

    private boolean isNumberContainsThree(int number) {
        return valueOf(number).contains("3");
    }

    private boolean isMultipleOf(int number, int divider) {
        return number % divider == 0;
    }

    private void validateRange(int start, int end) {
        if (start > end) {
            throw new InvalidRangeException("Invalid Range. start should be less than or equal to end");
        }
    }

    private String mapToWordsOrInteger(String word) {
        return isWord(word) ? word : "integer";
    }

    private boolean isWord(String word) {
        return word.chars().noneMatch(Character::isDigit);
    }

    private String buildReport(String fizzBuzzNumbers, Map<String, Long> wordCountMap) {
        return new StringBuilder(fizzBuzzNumbers)
                .append(" fizz: ").append(wordCountMap.getOrDefault("fizz", 0L))
                .append(" buzz: ").append(wordCountMap.getOrDefault("buzz", 0L))
                .append(" fizzbuzz: ").append(wordCountMap.getOrDefault("fizzbuzz", 0L))
                .append(" lucky: ").append(wordCountMap.getOrDefault("lucky", 0L))
                .append(" integer: ").append(wordCountMap.getOrDefault("integer", 0L))
                .toString();
    }
}