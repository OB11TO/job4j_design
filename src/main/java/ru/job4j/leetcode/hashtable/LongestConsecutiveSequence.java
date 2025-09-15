package ru.job4j.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int maxSize = 0;
        int size = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                size++;
            } else {
                maxSize = Math.max(maxSize, size);
                size = 0;
            }
        }

        return Math.max(maxSize, size) + 1;
    }

    public int longestConsecutiveWithOn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> seqElm = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            seqElm.add(nums[i]);
        }

        int maxSeq = 1;
        for (int num : seqElm) {
            if (!seqElm.contains(num - 1)) {
                int length = 1;
                while (seqElm.contains(num + length)) {
                    length++;
                }
                maxSeq = Math.max(maxSeq, length);
            }
        }
        return maxSeq;
    }
}
