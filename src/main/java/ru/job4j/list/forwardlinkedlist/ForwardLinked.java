package ru.job4j.list.forwardlinkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        modCount++;
        Node<T> l = head;
        Node<T> newNode = new Node<>(value, null);
        if (l == null) {
            head = newNode;
        } else {
            while (l.next != null) {
                l = l.next;
            }
            l.next = newNode;
        }
        size++;
    }

    public void addFirst(T value) {
        modCount++;
        Node<T> f = head;
        head = new Node<>(value, f);
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.size);
        Node<T> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public T deleteFirst() {
        Node<T> node = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        modCount++;
        Node<T> next = head.next;
        node.next = null;
        head = next;
        size--;
        return node.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = node.item;
                node = node.next;
                return item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}