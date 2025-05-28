package ru.job4j.structures.iterator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<Integer>> data = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        List<Integer> flat =
                data.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList());
        System.out.println(flat);

        List<Stream<Integer>> collect = data.stream()
                .map(List::stream)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}