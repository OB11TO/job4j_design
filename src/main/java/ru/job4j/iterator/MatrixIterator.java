package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (column < data.length && row >= data[column].length) {
            column++;
            row = 0;
        }
        return column < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[column][row++];
    }
}