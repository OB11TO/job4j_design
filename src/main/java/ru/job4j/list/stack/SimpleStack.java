package ru.job4j.list.stack;

import ru.job4j.list.forwardlinkedlist.ForwardLinked;

public class SimpleStack<T> {

    private final ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}