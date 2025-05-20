package ru.job4j.statistic;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalizeTest {

    @Test
    void whenNotChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3);
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(0, 0, 0));
    }

    @Test
    void whenOneChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, new User(2, "BB"), u3);
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(0, 1, 0));
    }

    @Test
    void whenOneDeleted() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u3);
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(0, 0, 1));
    }

    @Test
    void whenOneAdded() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3, new User(4, "D"));
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(1, 0, 0));
    }

    @Test
    void whenAllChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(new User(1, "AA"), u2, new User(4, "D"));
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(1, 1, 1));
    }

    @Test
    void whenBothEmpty() {
        Set<User> previous = Set.of();
        Set<User> current = Set.of();
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(0, 0, 0));
    }

    @Test
    void whenPreviousEmptyAndCurrentNonEmpty() {
        Set<User> previous = Set.of();
        Set<User> current = Set.of(
                new User(1, "A"),
                new User(2, "B")
        );
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(2, 0, 0));
    }

    @Test
    void whenPreviousNonEmptyAndCurrentEmpty() {
        Set<User> previous = Set.of(
                new User(1, "A"),
                new User(2, "B")
        );
        Set<User> current = Set.of();
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(0, 0, 2));
    }

    @Test
    void whenMultipleMixedChanges() {
        Set<User> previous = Set.of(
                new User(1, "A"),
                new User(2, "B"),
                new User(3, "C")
        );
        Set<User> current = Set.of(
                new User(1, "AA"),
                new User(2, "B"),
                new User(4, "D"),
                new User(5, "E")
        );
        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(2, 1, 1));
    }

    @Test
    void whenSameIdSameNameButNewInstances() {
        User prev1 = new User(1, "A");
        User prev2 = new User(2, "B");
        Set<User> previous = Set.of(prev1, prev2);

        User cur1 = new User(1, "A");
        User cur2 = new User(2, "B");
        Set<User> current = Set.of(cur1, cur2);

        assertThat(Analize.diff(previous, current)).isEqualTo(new Info(0, 0, 0));
    }
}