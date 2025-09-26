package ru.job4j.leetcode.stack;

import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);

        Stack<Integer> stack = new Stack<>();
        List<String> operators = List.of("+", "-", "*", "/");
        for (String token : tokens) {
            if (operators.contains(token)) {
                Integer arg1 = stack.pop();
                Integer arg2 = stack.pop();
                switch (token) {
                    case "+" -> stack.push(arg2 + arg1);
                    case "-" -> stack.push(arg2 - arg1);
                    case "*" -> stack.push(arg2 * arg1);
                    case "/" -> stack.push(arg2 / arg1);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
