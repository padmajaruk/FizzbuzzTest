package com.equalexperts.fb;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {
    private final FizzBuzz fizzbuzz = new FizzBuzz();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowException_whenGenerateFizzBuzz_givenInvalidRange() {
        expectedException.expect(InvalidRangeException.class);
        expectedException.expectMessage("Invalid Range. start should be less than or equal to end");
        fizzbuzz.generateFizzBuzz(15, 10);
    }

    @Test
    public void shouldReturnFizzWithReport_whenGenerateFizzBuzz_givenRangeHasOnlySix() {
        String actualText = fizzbuzz.generateFizzBuzz(6, 6);
        assertThat(actualText, is("fizz fizz: 1 buzz: 0 fizzbuzz: 0 lucky: 0 integer: 0"));
    }

    @Test
    public void shouldReturnBuzzWithReport_whenGenerateFizzBuzz_givenRangeHasOnlyFive() {
        String actualText = fizzbuzz.generateFizzBuzz(5, 5);
        assertThat(actualText, is("buzz fizz: 0 buzz: 1 fizzbuzz: 0 lucky: 0 integer: 0"));
    }

    @Test
    public void shouldReturnFizzBuzzWithReport_whenGenerateFizzBuzz_givenRangeHasOnlyFifteen() {
        String actualText = fizzbuzz.generateFizzBuzz(15, 15);
        assertThat(actualText, is("fizzbuzz fizz: 0 buzz: 0 fizzbuzz: 1 lucky: 0 integer: 0"));
    }

    @Test
    public void shouldReturnFizzBuzzWithReport_whenGenerateFizzBuzz_givenRangeHasOnlyZero() {
        String actualText = fizzbuzz.generateFizzBuzz(0, 0);
        assertThat(actualText, is("fizzbuzz fizz: 0 buzz: 0 fizzbuzz: 1 lucky: 0 integer: 0"));
    }

    @Test
    public void shouldReturnFizzBuzzNumbersWithReport_whenGenerateFizzBuzz_givenNegativeRange() {
        final String actualText = fizzbuzz.generateFizzBuzz(-5, 15);
        assertThat(actualText, is("buzz -4 lucky -2 -1 fizzbuzz 1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz fizz: 3 buzz: 3 fizzbuzz: 2 lucky: 3 integer: 10"));
    }

    @Test
    public void shouldReturnFizzBuzzNumbersWithReport_whenGenerateFizzBuzz_givenRangeFrom1To20() {
        String actualText = fizzbuzz.generateFizzBuzz(1, 20);
        assertThat(actualText, is("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10"));
    }

    @Test
    public void shouldReturnLuckyWithReport_whenGenerateFizzBuzz_givenRangeHasOnlyThree() {
        String actualText = fizzbuzz.generateFizzBuzz(23, 23);
        assertThat(actualText, is("lucky fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 1 integer: 0"));
    }

    @Test
    public void shouldReturnLuckyWithReport_whenGenerateFizzBuzz_givenRangeIncludesMultipleThree() {
        String actualText = fizzbuzz.generateFizzBuzz(30, 39);
        assertThat(actualText, is("lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 10 integer: 0"));
    }

    @Test
    public void shouldReturnFizzBuzzNumbersWithReport_whenGenerateFizzBuzz_givenRangeHasOnlySix() {
        String actualText = fizzbuzz.generateFizzBuzz(1, 20);
        assertThat(actualText, is("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10"));
    }
}
