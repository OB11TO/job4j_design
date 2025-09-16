package ru.job4j.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        int window = s1.length();
        for (int i = 0; i <= s2.length() - window; i++) {
            if (set.contains(s2.charAt(i))) {
                String subStr = s2.substring(i, i + window);
                if (isPermutation(s1, subStr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPermutation(String s1, String s2) {
        int[] alh = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            alh[s1.charAt(i) - 'a']++;
            alh[s2.charAt(i) - 'a']--;
        }
        for (int i : alh) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
