package ru.job4j.leetcode.stack;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures.length == 1) {
            return result;
        }
        Stack<Integer> stackIndexDay = new Stack<>();
        for (int indexDay = 0; indexDay < temperatures.length; indexDay++) {
            while (!stackIndexDay.isEmpty()
                    && temperatures[stackIndexDay.peek()] < temperatures[indexDay]) {
                int indexPrevDay = stackIndexDay.pop();
                result[indexPrevDay] = indexDay - indexPrevDay;
            }
            stackIndexDay.push(indexDay);
        }
        return result;
    }
}
