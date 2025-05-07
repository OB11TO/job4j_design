package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
/*
        asList();
        listOf();
*/
        List<String> result = new ArrayList<>(); // В ОБЫЧНОМ СПИСКЕ МОЖНО ВСЁ ДЕЛАТЬ
        result.add("one");
        result.add("two");
        result.add("three");
        result.remove(0);

        result.replaceAll(n -> n + 1); // Заменяет каждый элемент списка на результат применения оператора

        result.sort(String::compareTo); // Передать Компаратор

        for (String string : result) {
            System.out.println("Текущий элемент: " + string);
        }
    }

    private static void listOf() {
        List<String> listOf = List.of("a", "b", "c"); // СПИСОК ПОЛНОСТЬЮ НЕЛЬЗЯ МОДИФИЦИРОВАТЬ И МЕНЯТЬ !!! UnsupportedOperationException
        listOf.set(0, "e"); // НЕЛЬЗЯ
        listOf.add("d"); // НЕЛЬЗЯ
        listOf.remove("a"); // НЕЛЬЗЯ
    }

    private static void asList() {
        List<String> list = Arrays.asList("a", "b", "c"); // В ЭТОМ СПИСКЕ НЕЛЬЗЯ ДОБАВИТЬ ИЛИ УДАЛИТЬ ЭЛЕМЕНТЫ, будет .UnsupportedOperationException
        list.remove(0); //НЕЛЬЗЯ
        list.add("d"); // НЕЛЬЗЯ
        list.set(0, "d"); // НО МОДИФИЦИРОВАТЬ МОЖНО !!!!!!!!!
    }
}