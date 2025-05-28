package ru.job4j.structures.set;

import ru.job4j.structures.list.dynamicarray.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArraySet<T> implements SimpleSet<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean added = false;
        if (!contains(value)) {
            set.add(value);
            added = true;
        }
        return added;
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        for (T element : set) {
            if (Objects.equals(value, element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}