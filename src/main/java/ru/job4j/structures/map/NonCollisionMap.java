package ru.job4j.structures.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;
    private int count = 0;
    private int threshold = (int) (capacity * LOAD_FACTOR);
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            modCount++;
            if (++count >= threshold) {
                expand();
            }
            result = true;
        }
        return result;
    }

    @Override
    public V get(K key) {
        V result = null;
        int index = getIndex(key);
        MapEntry<K, V> entry = table[index];
        if (entry != null && keysMatch(key, entry)) {
            result = entry.value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = getIndex(key);
        MapEntry<K, V> entry = table[index];
        if (entry != null && keysMatch(key, entry)) {
            result = true;
            table[index] = null;
            modCount++;
            count--;
        }
        return result;
    }

    private boolean keysMatch(K key, MapEntry<K, V> entry) {
        return Objects.hashCode(key) == Objects.hashCode(entry.key)
                && Objects.equals(key, entry.key);
    }

    private int getIndex(K key) {
        int hashCode = Objects.hashCode(key);
        int hash = hash(hashCode);
        return indexFor(hash);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private final int preModCount = modCount;
            private int index = 0;

            public boolean hasNext() {
                if (preModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity;
            }

            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                MapEntry<K, V> entry = table[index++];
                return entry.key;
            }

        };
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        threshold = (int) (capacity * LOAD_FACTOR);
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                K key = entry.key;
                int index = getIndex(key);
                newTable[index] = entry;
            }
        }
        table = newTable;
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
