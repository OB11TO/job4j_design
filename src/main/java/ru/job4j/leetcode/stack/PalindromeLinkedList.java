package ru.job4j.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
    }

    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> list = new ArrayDeque<>();
        while (head != null) {
            list.addLast(head.val);
            head = head.next;
        }
        return isPalindromeList(list);
    }

    private static boolean isPalindromeList(Deque<Integer> list) {
        while (!list.isEmpty()) {
            if (!Objects.equals(list.getFirst(), list.getLast())) {
                return false;
            }
            list.pollFirst();
            list.pollLast();
        }
        return true;
    }

    public boolean isPalindromeWithStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        while (head != null && stack.pop() == head.val) {
            head = head.next;
        }
        return stack.isEmpty();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
