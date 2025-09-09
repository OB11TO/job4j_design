package ru.job4j.leetcode.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if (s.length() == 1) {
            return List.of(1);
        }
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> mapIndex = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapIndex.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, mapIndex.get(s.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
