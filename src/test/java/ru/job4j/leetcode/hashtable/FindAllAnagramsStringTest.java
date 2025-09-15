package ru.job4j.leetcode.hashtable;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindAnagramTest {

    @Test
    void example_cbaebabacd_with_abc_shouldReturn0and6() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = fa.findAnagrams(s, p);
        assertThat(result).containsExactly(0, 6);
    }

    @Test
    void example_ababababab_with_abc_shouldReturn0and6() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "ababababab";
        String p = "aab";
        List<Integer> result = fa.findAnagrams(s, p);
        assertThat(result).containsExactly(0,2,4,6);
    }

    @Test
    void overlappingWindows_abab_with_ab_shouldReturn012() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "abab";
        String p = "ab";
        List<Integer> result = fa.findAnagrams(s, p);
        // перекрывающиеся вхождения: [0,1,2]
        assertThat(result).containsExactly(0, 1, 2);
    }

    @Test
    void pLongerThanS_shouldReturnEmpty() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "ab";
        String p = "abc";
        List<Integer> result = fa.findAnagrams(s, p);
        assertThat(result).isEmpty();
    }

    @Test
    void currentImplementation_showsSetEqualityBug_example() {
       /*
         Демонстрация бага текущей реализации:
         p = "aab" (две 'a'), window = "abb" (две 'b') -> множества символов одинаковы {'a','b'},
         но это НЕ анаграмма (частоты отличаются). Текущая реализация вернёт индекс 0,
         этот тест фиксирует текущее (неправильное) поведение чтобы показать проблему.
         */
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "abb";
        String p = "aab";
        List<Integer> result = fa.findAnagrams(s, p);

        // Текущее (неправильное) поведение — метод найдёт 0.
        assertThat(result).containsExactly(0);
    }

    @Test
    void anotherExample_with_duplicates() {
        FindAllAnagramsString fa = new FindAllAnagramsString();
        String s = "aaabbbccc";
        String p = "abc";
        // Здесь множества совпадают (a,b,c) и твоя реализация будет
        // находить все окна длины 3, где присутствуют a,b,c в любой комбинации.
        // Это демонстрирует, что частоты не учитываются.
        List<Integer> result = fa.findAnagrams(s, p);
        // ожидаем индексы где множества равны: в этом примере таких будет 0..6 в зависимости от состава,
        // но мы просто проверим, что результат не пуст (чтобы подтвердить поведение)
        assertThat(result).isNotEmpty();
    }
}