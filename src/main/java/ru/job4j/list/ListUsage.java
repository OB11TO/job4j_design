package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        result.add("one");
        result.add("two");
        result.add("three");
        result.remove(0);

        result.replaceAll(n -> n + 1);

        result.sort(String::compareTo);

        for (String string : result) {
            System.out.println("Текущий элемент: " + string);
        }
    }

    private static void listOf() {
        List<String> listOf = List.of("a", "b", "c");
        listOf.set(0, "e");
        listOf.add("d");
        listOf.remove("a");
    }

    private static void asList() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.remove(0);
        list.add("d");
        list.set(0, "d");
    }
}