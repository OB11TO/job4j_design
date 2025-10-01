package ru.job4j.leetcode.stack;

import java.util.Stack;

public class LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        Stack<Integer> stack = new Stack<>();
        int maxSize = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxSize = Math.max(maxSize, h * w);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? heights.length
                    : heights.length - stack.peek() - 1;
            maxSize = Math.max(maxSize, h * w);
        }

        return maxSize;
    }
}
