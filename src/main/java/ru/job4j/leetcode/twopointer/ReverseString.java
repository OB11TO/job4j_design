package ru.job4j.leetcode.twopointer;

public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left <= right) {

            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            right--;
            left++;

        }
    }
}
