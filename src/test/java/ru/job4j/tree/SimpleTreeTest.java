package ru.job4j.tree;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleTreeTest {

    @Test
    void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6)).isPresent();
    }

    @Test
    void whenElFindNotExistThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7)).isEmpty();
    }

    @Test
    void whenChildExistOnLeafThenNotAdd() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.add(2, 6)).isFalse();
    }

    @Test
    void whenAddMultipleChildrenToSameParent() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);

        assertThat(tree.findBy(2)).isPresent();
        assertThat(tree.findBy(3)).isPresent();
        assertThat(tree.findBy(4)).isPresent();
    }

    @Test
    void whenAddSelfAsChildThenFail() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertThat(tree.add(1, 1)).isFalse();
    }

    @Test
    void whenFindRootThenPresent() {
        Tree<Integer> tree = new SimpleTree<>(10);
        assertThat(tree.findBy(10)).isPresent();
    }

    @Test
    void whenAddMultipleLevelsThenFindAll() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(2, 3);
        tree.add(3, 4);
        tree.add(4, 5);

        for (int i = 2; i <= 5; i++) {
            assertThat(tree.findBy(i)).isPresent();
        }
    }


}