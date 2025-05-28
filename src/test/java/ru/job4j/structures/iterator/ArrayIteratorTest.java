package ru.job4j.structures.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.job4j.structures.iterator.ArrayIterator;

import java.util.NoSuchElementException;

public class ArrayIteratorTest {

    @Test
    void whenMultiCallHasNextThenTrue() {
        ArrayIterator iterator = new ArrayIterator(
                new int[]{1, 2, 3}
        );
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
    }

    @Test
    void whenReadSequence() {
        ArrayIterator iterator = new ArrayIterator(
                new int[]{1, 2, 3}
        );
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
    }

    @Test
    void whenNextFromEmpty() {
        ArrayIterator iterator = new ArrayIterator(
                new int[] {}
        );
        assertThatThrownBy(iterator::next).isInstanceOf(NoSuchElementException.class);
    }
}