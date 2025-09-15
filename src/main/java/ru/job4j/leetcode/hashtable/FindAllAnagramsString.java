package ru.job4j.leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllAnagramsString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        List<Character> anagrams = findAnagramsP(p);
        int windowSize = p.length();
        for (int i = 0; i <= s.length() - windowSize; i++) {
            String subStr = s.substring(i, i + windowSize);
            List<Character> subSet = findAnagramsP(subStr);
            if (anagrams.equals(subSet)) {
                result.add(i);
            }
        }
        return result;
    }

    private List<Character> findAnagramsP(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> findAnagramsWithArray(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int windowSize = p.length();
        for (int i = 0; i <= s.length() - windowSize; i++) {
            String subStr = s.substring(i, i + windowSize);
            if (isAnagram(subStr, p)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagram(String subStr, String template) {
        int[] alhp = new int[26];
        for (int i = 0; i < subStr.length(); i++) {
            alhp[subStr.charAt(i) - 'a']++;
            alhp[template.charAt(i) - 'a']--;
        }

        for (int j : alhp) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}
