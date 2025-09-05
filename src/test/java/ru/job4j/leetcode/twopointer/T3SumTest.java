package ru.job4j.leetcode.twopointer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class T3SumTest {

    private final T3Sum solver = new T3Sum();

    @Test
    @DisplayName("Пример из условия задачи: [-1,0,1,2,-1,-4]")
    void whenExampleInputThenCorrectTriplets() {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = solver.threeSum(nums);

        assertThat(result)
                .containsExactlyInAnyOrder(
                        List.of(-1, -1, 2),
                        List.of(-1, 0, 1)
                );
    }

    @Test
    @DisplayName("Нет решений: [1,2,3]")
    void whenNoSolutionThenEmptyList() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = solver.threeSum(nums);

        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Меньше 3 элементов: [0,1]")
    void whenLessThanThreeElementsThenEmptyList() {
        int[] nums = {0, 1};

        List<List<Integer>> result = solver.threeSum(nums);

        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Все элементы равны нулю: [0,0,0,0]")
    void whenAllZerosThenOneTriplet() {
        int[] nums = {0, 0, 0, 0};

        List<List<Integer>> result = solver.threeSum(nums);

        assertThat(result)
                .containsExactly(List.of(0, 0, 0));
    }

    @Test
    @DisplayName("Дубликаты: [-2,0,0,2,2]")
    void whenDuplicatesThenUniqueTripletsOnly() {
        int[] nums = {-2, 0, 0, 2, 2};

        List<List<Integer>> result = solver.threeSum(nums);

        assertThat(result)
                .containsExactly(List.of(-2, 0, 2));
    }

    @Test
    @DisplayName("Разные комбинации: [-1,0,1,0]")
    void whenMultipleValidTripletsThenAllReturned() {
        int[] nums = {-1, 0, 1, 0};

        List<List<Integer>> result = solver.threeSum(nums);

        assertThat(result)
                .containsExactly(List.of(-1, 0, 1));
    }

    @Test
    @DisplayName("Когда все нули в массиве")
    void whenForElementArrayZero() {
        int[] nums = {0,0,0,0};
        List<List<Integer>> result = solver.threeSum(nums);
        assertThat(result).containsExactly(List.of(0, 0, 0));
    }
}
