package ru.job4j.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        this.stack = new LinkedList<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.addLast(val);
        if (minStack.peekFirst() != null) {
            int value = Math.min(minStack.peekFirst(), val);
            minStack.addFirst(value);
        } else {
            minStack.addFirst(val);
        }

    }

    public void pop() {
        stack.removeLast();
        minStack.removeFirst();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.peekFirst() != null ? minStack.peekFirst() : Integer.MAX_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */