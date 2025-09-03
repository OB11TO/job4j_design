package ru.job4j.leetcode.twopointer;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroesInPlace(new int[]{0, 1, 0, 3, 12});
        moveZeroesALL(new int[]{0, 1, 0, 3, 12});
        moveZeroesALL(new int[]{1, 1, 0, 3, 12});
    }

    /**
     * In-place means we should not be allocating any space for extra array. But we are allowed to modify the existing array. However, as a first step, try coming up with a solution that makes use of additional space. For this problem as well, first apply the idea discussed using an additional array and the in-place solution will pop up eventually.
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] buffer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                buffer[right--] = nums[i];
            } else {
                buffer[left++] = nums[i];
            }
        }
        nums = buffer;
    }

    public static void moveZeroesInPlace(int[] nums) {
        int left = 0;
        int countNull = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            } else {
                countNull++;
            }
        }
        int index = nums.length - 1;
        while (countNull > 0) {
            nums[index--] = 0;
            countNull--;
        }
        System.out.println();
    }

    public static void moveZeroesALL(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        System.out.println();
    }
}
