package ru.job4j.leetcode.two_pointer;

import java.util.List;

public class ReverseVowelsString {

    private final List<Character> vowels;

    public ReverseVowelsString() {
        vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    }

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left <= right) {
            if (vowels.contains(chars[left]) && vowels.contains(chars[right])) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                right--;
                left++;
            } else if (vowels.contains(chars[left])) {
                right--;
            } else {
                left++;
            }
        }
        return new String(chars);
    }
}
