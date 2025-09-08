package ru.job4j.leetcode.twopointer;

public class ContainerWithMostWater {

    public int maxAreaWithGreedy(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            if (height[left] >= height[right]) {
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--;
            } else {
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;
            }
        }
        return maxArea;
    }

    /**
     * Использую только метод с two_pointer
     * Но это не оптимальное решение, так как сложность O(n^2)
     * <p>
     * Нужно использовать еще жадный алгоритм
     */
    public int maxArea(int[] height) {
        int maxS = 0;
        for (int left = 0; left < height.length - 1; left++) {
            int right = left + 1;
            while (right < height.length) {
                int first = height[left];
                int second = height[right];
                if (first > second) {
                    maxS = Math.max(maxS, second * (right - left));
                } else if (first < second) {
                    maxS = Math.max(maxS, first * (right - left));
                } else {
                    maxS = Math.max(maxS, first * (right - left));
                }
                right++;
            }
        }
        return maxS;
    }
}