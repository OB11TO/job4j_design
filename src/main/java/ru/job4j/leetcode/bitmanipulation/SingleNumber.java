package ru.job4j.leetcode.bitmanipulation;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int tmp = 0;
        for (int i : nums) {
            tmp = tmp ^ i;
        }
        return tmp;
    }
}
