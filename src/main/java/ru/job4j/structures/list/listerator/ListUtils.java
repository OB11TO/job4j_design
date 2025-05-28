package ru.job4j.structures.list.listerator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }
        ListIterator<T> iterator = list.listIterator(index + 1);
        iterator.add(value);
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(filter);
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(filter);
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                iterator.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(elements);
        removeIf(list, elements::contains);
    }
}