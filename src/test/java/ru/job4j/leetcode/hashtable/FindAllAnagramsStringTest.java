package ru.job4j.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindAnagramTest {

    @Test
    void withABCShouldReturn0and6() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = fa.findAnagramsWithArray(s, p);
        assertThat(result).containsExactly(0, 6);
    }

    @Test
    void withAbcShouldReturn0and6() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "ababababab";
        String p = "aab";
        List<Integer> result = fa.findAnagramsWithArray(s, p);
        assertThat(result).containsExactly(0, 2, 4, 6);
    }

    @Test
    void overlappingWindowsShouldReturn012() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "abab";
        String p = "ab";
        List<Integer> result = fa.findAnagramsWithArray(s, p);
        assertThat(result).containsExactly(0, 1, 2);
    }

    @Test
    void pLongerThanShouldReturnEmpty() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "ab";
        String p = "abc";
        List<Integer> result = fa.findAnagramsWithArray(s, p);
        assertThat(result).isEmpty();
    }
}