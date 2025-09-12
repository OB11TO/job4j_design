package ru.job4j.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }

        result = map.entrySet()
                .stream()
                //.sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()) // сортируем по значению
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();

        return result;

    }

    public int[] topKFrequentBucketSort(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.merge(n, 1, Integer::sum);
        }
        List<List<Integer>> buckets = new ArrayList<>(Collections.nCopies(nums.length + 1, null));
        for (int i = 0; i < nums.length; i++) {
            buckets.add(null);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            Integer freq = entry.getValue();
            if (buckets.get(freq) == null) {
                buckets.set(freq, new ArrayList<>());
            }
            buckets.get(freq).add(entry.getKey());
        }

        int[] result = new int[k];
        int indx = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            List<Integer> freqElms = buckets.get(i);
            if (freqElms == null) {
                continue;
            }
            for (Integer freqElm : freqElms) {
                result[indx++] = freqElm;
                if (indx == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
