package ru.job4j.leetcode;

import org.junit.jupiter.api.Test;
import ru.job4j.leetcode.twopointer.SmallestRangeFinder;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallestRangeFinderTest {

    @Test
    public void whenFindSmallestRangeUniqueElementsThenReturnsExpectedRange() {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] expectedRange = {0, 2};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenFindSmallestRangeRepeatedElementsThenReturnsExpectedRange() {
        int[] nums = {1, 2, 3, 3, 5, 6, 7};
        int k = 4;
        int[] expectedRange = {3, 6};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenNotFound() {
        int[] nums = {1, 2, 3, 3, 3};
        int k = 4;
        int[] expectedRange = null;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenArrayLengthSmallerThanKThenReturnNull() {
        int[] nums = {1, 2};
        int k = 3;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isNull();
    }

    @Test
    public void whenArrayWithOneElementAndKis1ThenReturnRange() {
        int[] nums = {42};
        int k = 1;
        int[] expectedRange = {0, 0};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenAllElementsAreSameAndKis1ThenReturnFirstIndex() {
        int[] nums = {5, 5, 5, 5, 5};
        int k = 1;
        int[] expectedRange = {0, 0};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenAllElementsAreSameAndKisMoreThan1ThenReturnNull() {
        int[] nums = {5, 5, 5, 5, 5};
        int k = 2;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isNull();
    }

    @Test
    public void whenRangeIsAtEndOfArray() {
        int[] nums = {1, 1, 1, 2, 3, 4};
        int k = 3;
        int[] expectedRange = {2, 4};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenRangeIsAtBeginningOfArray() {
        int[] nums = {1, 2, 3, 3, 3, 3, 3};
        int k = 3;
        int[] expectedRange = {0, 2};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenMinimalWindowNotTrivial() {
        int[] nums = {1, 2, 2, 3, 4, 5, 6};
        int k = 4;
        int[] expectedRange = {2, 5};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenKequalsArrayLengthDistinctElements() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        int[] expectedRange = {0, 4};
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenLargeArrayWithManyDuplicates() {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7};
        int k = 5;
        int[] expectedRange = null;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isEqualTo(expectedRange);
    }

    @Test
    public void whenKisZeroThenReturnNull() {
        int[] nums = {1, 2, 3};
        int k = 0;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isNull();
    }

    @Test
    public void whenEmptyArrayThenReturnNull() {
        int[] nums = {};
        int k = 1;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isNull();
    }

    @Test
    public void whenKisZeroThenReturn() {
        int[] nums = {-1, -2, 3};
        int k = 0;
        assertThat(SmallestRangeFinder.findSmallestRange(nums, k)).isNull();
    }
}