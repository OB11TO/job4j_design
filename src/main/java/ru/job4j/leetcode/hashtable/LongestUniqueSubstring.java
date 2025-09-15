package ru.job4j.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    public static String longestUniqueSubstring(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxSize = 0;
        int start = 0;
        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            if (maxSize < right - left + 1) {
                maxSize = right - left + 1;
                start = left;
            }
        }
        return str.substring(start, start + maxSize);
    }
}
