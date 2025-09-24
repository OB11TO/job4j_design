package ru.job4j.leetcode.stack;

import java.util.Stack;

public class ReversePrefixWord {

    public String reversePrefixStringBuilder(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0, idx + 1));
        sb.reverse();
        return sb.append(word.substring(idx + 1)).toString();
    }

    public String reversePrefixTwoPointer(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        char[] chars = word.toCharArray();
        int left = 0;
        int right = index;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }

    public String reversePrefixWithStack(String word, char ch) {
        int indx = word.indexOf(ch);
        if (indx == -1) {
            return word;
        }
        Stack<Character> stack = new Stack<>();
        String startWord = word.substring(0, indx + 1);
        String endWord = word.substring(indx + 1);
        for (char c : startWord.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.append(endWord);
        return sb.toString();
    }
}
