package ru.job4j.list.listerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenPredicateNull() {
        assertThatThrownBy(() -> ListUtils.removeIf(input, null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void whenPredicateDividerWithoutRemainder() {
        ListUtils.removeIf(input, x -> x % 2 != 0);
        assertThat(input).isEmpty();
    }

    @Test
    void shouldRemoveAllElementsIfAllMatchPredicate() {
        ListUtils.removeIf(input, x -> x > 1);
        assertThat(input).hasSize(1).containsSequence(1);
    }

    @Test
    void shouldThrowIfListIsNull() {
        assertThatThrownBy(() ->
                ListUtils.replaceIf(null, x -> true, 0)
        ).isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldThrowIfPredicateIsNull() {
        assertThatThrownBy(() ->
                ListUtils.replaceIf(input, null, 0)
        ).isInstanceOf(NullPointerException.class);
    }

    @Test
    void shouldReplaceAllElementsIfAllMatch() {
        ListUtils.replaceIf(input, x -> true, 9);
        assertThat(input).containsExactly(9, 9);
    }

    @Test
    void shouldRemoveAllMatchingElements() {
        List<Integer> toRemove = Arrays.asList(1, 3);
        ListUtils.removeAll(input, toRemove);
        assertThat(input).isEmpty();
    }

    @Test
    void shouldRemoveNothingIfNoElementsMatch() {
        List<Integer> toRemove = List.of(3);
        ListUtils.removeAll(input, toRemove);
        assertThat(input).containsExactly(1);
    }

}