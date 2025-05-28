package ru.job4j.structures.set;

public interface SimpleSet<T> extends Iterable<T> {

    boolean add(T value);

    boolean contains(T value);
}