package ru.job4j.leetcode.prefixsum;

public class RangeSumQueryImmutable {
    private int[] nums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int[] prefix; // prefix sum array

    public RangeSumQueryImmutable(int[] nums, int k) {
        int n = nums.length;
        prefix = new int[n + 1];  // prefix[0] = 0
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRangePrefix(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        int result = rangeSumQueryImmutable.sumRange(0, 2);
        System.out.println(result);
    }
}
