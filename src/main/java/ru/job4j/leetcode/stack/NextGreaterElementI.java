package ru.job4j.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for(int j = 0; j < nums2.length; j++) {
            while (!stack.isEmpty()
                    && nums2[stack.peek()] < nums2[j]
                    && map.containsKey(nums2[stack.peek()])) {
                int index = map.get(nums2[stack.pop()]);
                int value = nums2[j];
                result[index] = value;
            }
            if (map.containsKey(nums2[j])) {
                stack.push(j);
            }
        }
        while (!stack.isEmpty()) {
            int index = map.get(nums2[stack.pop()]);
            result[index] = -1;
        }
        return result;
    }
}
