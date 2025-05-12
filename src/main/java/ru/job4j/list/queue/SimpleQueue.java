package ru.job4j.list.queue;

import ru.job4j.list.stack.SimpleStack;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {

    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    private int sizeInput;
    private int sizeOutput;

    public T poll() {
        if (isEmptyInput()) {
            throw new NoSuchElementException("Queue is empty");
        }
        sizeInput--;
        return input.pop();
    }

    public void push(T value) {
        while (!isEmptyInput()) {
            output.push(input.pop());
            sizeOutput++;
            sizeInput--;
        }
        input.push(value);
        sizeInput++;
        while (!isEmptyOutput()) {
            input.push(output.pop());
            sizeInput++;
            sizeOutput--;
        }
    }

    private boolean isEmptyInput() {
        return sizeInput == 0;
    }

    private boolean isEmptyOutput() {
        return sizeOutput == 0;
    }
}