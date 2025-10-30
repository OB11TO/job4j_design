package ru.job4j.leetcode.binarysearch;

public class SearchSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{0, 1, 1, 2, 0, 0}, 2));
        Solution solution = new Solution();


        System.out.println(solution.findMinimalLeftElement(new int[]{1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1}));
        System.out.println(findMinimalLeftElementGood(new int[]{1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1}));
        System.out.println(solution.findMinimalLeftElement(new int[]{0, 1, 2, 3, 4, 5, 6, 0}));
        System.out.println(findMinimalLeftElementGood(new int[]{0, 1, 2, 3, 4, 5, 6, 0}));
        System.out.println(solution.findMinimalLeftElement(new int[]{0, 1, 2, 3, 4, 5, 6}));
        System.out.println(findMinimalLeftElementGood(new int[]{0, 1, 2, 3, 4, 5, 6}));
        System.out.println(solution.findMinimalLeftElement(new int[]{2, 5, 6, 0, 0, 1, 2}));
        System.out.println(findMinimalLeftElementGood(new int[]{2, 5, 6, 0, 0, 1, 2}));
        System.out.println(solution.findMinimalLeftElement(new int[]{0, 1, 1, 2, 0, 0}));
        System.out.println(findMinimalLeftElementGood(new int[]{0, 1, 1, 2, 0, 0}));
        System.out.println(findMinimalLeftElementGood(new int[]{1, 2, 0, 1, 1, 1}));
        System.out.println(findMinimalLeftElementGood(new int[]{2, 2, 2, 3, 2, 2, 2}));

    }


    private static int findMinimalLeftElementGood(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int ans = nums.length - 1;
        while (lo < hi) {
            int md = lo + (hi - lo) / 2;
            if (nums[lo] == nums[hi]) {
                lo++;
                continue;
            }
            if (nums[lo] < nums[hi]) {
                if (nums[ans] < nums[lo]) {
                    return ans;
                } else {
                    return lo;
                }
            }
            if (nums[md] > nums[hi]) {
                lo = md + 1;
            } else if (nums[md] <= nums[hi]) {
                ans = md;
                hi = md;
            } else {
                lo = md + 1;
            }
        }
        return ans;
    }


    public static boolean search(int[] nums, int target) {
        int minPosition = findMinimalLeftElementFail(nums);
        System.out.println(nums[minPosition] + "  " + minPosition);
        boolean result = false;
        if (target <= nums[nums.length - 1]) {
            result = binarySearch(nums, target, minPosition, nums.length - 1);
        } else {
            result = binarySearch(nums, target, 0, minPosition);
        }
        return result;
    }

    private static boolean binarySearch(int[] nums, int target, int lo, int hi) {
        boolean result = false;
        while (lo <= hi) {
            int md = lo + (hi - lo) / 2;
            if (nums[md] == target) {
                return true;
            } else if (nums[md] < target) {
                lo = md + 1;
            } else {
                hi = md - 1;
            }
        }
        return result;
    }

    private static int findMinimalLeftElementFail(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int ans = nums.length - 1;
        while (lo <= hi) {
            int md = lo + (hi - lo) / 2;
            if (lo < hi && nums[lo] == nums[hi]) {
                lo++;
            } else if (nums[lo] < nums[hi]) {
                if (nums[ans] < nums[lo]) {
                    return ans;
                } else {
                    return lo;
                }
            } else if (nums[md] > nums[hi]) {
                lo = md + 1;
            } else if (nums[md] < nums[hi]) {
                ans = md;
                hi = md - 1;
            } else {
                ans = md;
                hi = md - 1;
            }
        }
        return ans;
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int n = nums.length;
        int minPos = findMinimalLeftElement(nums);
        System.out.println(minPos + " " + nums[minPos]);

        // правая часть: [minPos .. n-1], левая: [0 .. minPos-1]
        if (target <= nums[n - 1]) {
            return binarySearch(nums, target, minPos, n - 1);
        } else {
            return binarySearch(nums, target, 0, minPos - 1);
        }
    }

    private boolean binarySearch(int[] nums, int target, int lo, int hi) {
        boolean result = false;
        while (lo <= hi) {
            int md = lo + (hi - lo) / 2;
            if (nums[md] == target) {
                return true;
            } else if (nums[md] < target) {
                lo = md + 1;
            } else {
                hi = md - 1;
            }
        }
        return result;
    }

    public int findMinimalLeftElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int ans = nums.length - 1;
        while (lo < hi) {
            int md = lo + (hi - lo) / 2;
            if (nums[lo] == nums[hi]) {
                lo++;
                continue;
            }
            if (nums[lo] < nums[hi]) {
                if (nums[ans] < nums[lo]) {
                    return ans;
                } else {
                    return lo;
                }
            }
            if (nums[md] > nums[hi]) {
                lo = md + 1;
            } else if (nums[md] <= nums[hi]) {
                ans = md;
                hi = md;
            } else {
                lo = md + 1;
            }
        }
        return ans;
    }
}
