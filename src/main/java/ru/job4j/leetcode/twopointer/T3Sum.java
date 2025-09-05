package ru.job4j.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int left;
        int right;

        //[-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int arg = nums[i];
            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                if (arg + nums[left] + nums[right] > 0) {
                    right--;
                } else if (arg + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(arg, nums[left], nums[right]));
                    do {
                        left++;
                    } while (nums[left] == nums[left - 1] && left < right);
                }
            }
        }
        return result;
    }
}