package ru.job4j.leetcode.twopointer;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater solver = new ContainerWithMostWater();

    @Test
    void whenIsGoodExample() {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int resultArea = solver.maxAreaWithGreedy(nums);
        assertThat(resultArea).isEqualTo(49);
    }

    @Test
    void whenArrayMini() {
        int[] nums = {1, 1};
        int resultArea = solver.maxAreaWithGreedy(nums);
        assertThat(resultArea).isEqualTo(1);
    }

    @Test
    void whenArrayNull() {
        int resultArea = solver.maxAreaWithGreedy(null);
        assertThat(resultArea).isEqualTo(0);
    }

    @Test
    void whenArraySizeOne() {
        int resultArea = solver.maxAreaWithGreedy(new int[]{1});
        assertThat(resultArea).isEqualTo(0);
    }

    @Test
    void whenArrayBigDate() throws IOException {
        List<Integer> listIntegers;
        listIntegers = Files.lines(Paths.get("src/test/resources/data/leetcode.twopointer/testBigDate.txt"))
                .flatMap(line -> Arrays.stream(line.split(",")))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        int[] height = listIntegers.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int resultArea = solver.maxAreaWithGreedy(height);
        assertThat(resultArea).isEqualTo(705634720);
    }

}