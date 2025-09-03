package ru.job4j.leetcode.two_pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("ReverseVowelsString — LeetCode")
class ReverseVowelsStringTest {

    private ReverseVowelsString solver;

    @BeforeEach
    void setUp() {
        solver = new ReverseVowelsString();
    }

    static Stream<Arguments> provideInputsForReverseVowels() {
        return Stream.of(
                Arguments.of("hello", "holle"),
                Arguments.of("LeetCode", "LeotCede"),
                Arguments.of("aeiou", "uoiea"),
                Arguments.of("bcdfg", "bcdfg"),
                Arguments.of("", ""),
                Arguments.of("a", "a"),
                Arguments.of("racecar", "racecar"),
                Arguments.of("a,b$c", "a,b$c")
        );
    }

    @ParameterizedTest(name = "\"{0}\" -> \"{1}\"")
    @MethodSource("provideInputsForReverseVowels")
    @DisplayName("reverseVowels: различные входы -> ожидаемый результат")
    void reverseVowels_variousInputs_returnsExpected(String input, String expected) {
        String actual = solver.reverseVowels(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("reverseVowels: смешанный регистр гласных корректно обрабатывается")
    void reverseVowels_mixedCase_returnsCorrect() {
        String input = "AbEoU";
        String expected = "UboEA";
        String actual = solver.reverseVowels(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("reverseVowels: при null бросает NullPointerException")
    void reverseVowels_null_throwsNullPointerException() {
        assertThatThrownBy(() -> solver.reverseVowels(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("null");
    }
}
