package ru.job4j.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TopKFrequentElementsTest {

    private final TopKFrequentElements solution = new TopKFrequentElements();

    @Test
    void testExample1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);

        // Проверяем, что длина массива = k
        assertThat(result).hasSize(k);

        // Проверяем, что содержатся правильные элементы (порядок не важен)
        assertThat(result).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    void testExample2() {
        int[] nums = {1};
        int k = 1;
        int[] result = solution.topKFrequent(nums, k);

        assertThat(result).hasSize(k);
        assertThat(result).containsExactly(1);
    }

    @Test
    void testExample3() {
        int[] nums = {4, 4, 4, 6, 6, 7, 7, 7, 7};
        int k = 1;
        int[] result = solution.topKFrequent(nums, k);

        assertThat(result).hasSize(k);
        assertThat(result).containsExactly(7);
    }

    @Test
    void testExample4() {
        int[] nums = {5, 5, 5, 1, 1, 2, 2, 2, 3, 3, 3, 3};
        int k = 3;
        int[] result = solution.topKFrequent(nums, k);

        assertThat(result).hasSize(k);
        assertThat(result).containsExactlyInAnyOrder(3, 5, 2);
    }

}