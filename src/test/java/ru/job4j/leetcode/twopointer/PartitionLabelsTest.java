package ru.job4j.leetcode.twopointer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PartitionLabelsTest {

    private final PartitionLabels solver = new PartitionLabels();

    @Test
    @DisplayName("Пример из условия задачи: [ababcc]")
    void whenExampleInput() {
        String input = "ababcc";

        List<Integer> result = solver.partitionLabels(input);

        assertThat(result)
                .contains(
                        4, 2
                );
    }

    @Test
    @DisplayName("Пример из условия задачи: [ababcc]")
    void whenExampleInputThenCorrect() {
        String input = "ababcbacadefegdehijhklij";

        List<Integer> result = solver.partitionLabels(input);

        assertThat(result)
                .contains(
                        9,7,8
                );
    }

}