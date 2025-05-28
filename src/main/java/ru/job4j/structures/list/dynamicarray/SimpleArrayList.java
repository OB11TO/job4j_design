package ru.job4j.structures.list.dynamicarray;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        if (size == container.length) {
            container = grow();
        }
        container[size++] = value;
    }

    private T[] grow() {
        return Arrays.copyOf(container, container.length == 0 ? 1 : container.length * 2);
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T oldValue = container[index];
        container[index] = newValue;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        final T[] c = container;
        T oldValue = c[index];
        removeFast(c, index);
        return oldValue;
    }

    private void removeFast(T[] c, int index) {
        modCount++;
        final int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(c, index + 1, c, index, newSize - index);
        }
        size = newSize;
        c[size] = null;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            final int expectedModCount = modCount;
            int iterationSize = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterationSize < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[iterationSize++];
            }
        };
    }
}