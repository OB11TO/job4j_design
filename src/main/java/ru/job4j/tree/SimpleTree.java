package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> parentNode = findBy(parent);
            if (parentNode.isPresent()) {
                parentNode.get().children.add(new Node<>(child));
                result = true;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(node -> node.value.equals(value));
    }

    public boolean isBinary() {
        boolean result = true;
        Optional<Node<E>> optionalNode = findByPredicate(node -> node.children.size() > 2);
        if (optionalNode.isPresent()) {
            result = false;
        }
        return result;
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> node = data.poll();
            if (condition.test(node)) {
                result = Optional.of(node);
                break;
            }
            data.addAll(node.children);
        }
        return result;
    }
}