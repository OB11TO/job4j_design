package ru.job4j.generics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Willed {
    public static void main(String[] args) {
        Function<? super Integer, ? extends Number> function = num -> 4;
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3});
        list.stream()
                .map(function)
                .forEach(System.out::println);
    }
}
