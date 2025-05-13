package ru.job4j.set;

import ru.job4j.list.dynamicarray.SimpleArrayList;

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
        Iterator<T> iterator = iterator();
        boolean result = false;
        while (iterator.hasNext()) {
            if (Objects.equals(value, iterator.next())) {
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