package ru.job4j.leetcode;

import java.util.Arrays;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int[] result = new int[2];

        while (right < nums.length) {
            if (right > 0 && nums[right] == nums[right - 1]) {
                left = right;
                count = 0;
            }
            count++;
            if (count == k) {
                result[0] = left;
                result[1] = right;
                return result;
            }
            right++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}