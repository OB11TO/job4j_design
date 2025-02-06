package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseWithNamesEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");

    }

    @Test
    void whenValidateThenFirstException() {
        NameLoad nameLoad = new NameLoad();
        String argKeyValueError = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(argKeyValueError))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("symbol '='")
                .hasMessageContaining(argKeyValueError);

    }

    @Test
    void whenValidateThenSecondException() {
        NameLoad nameLoad = new NameLoad();
        String argKeyValueError = "=key=value";
        assertThatThrownBy(() -> nameLoad.parse(argKeyValueError))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("key")
                .hasMessageContaining(argKeyValueError);
    }

    @Test
    void whenValidateThenThirdException() {
        NameLoad nameLoad = new NameLoad();
        String argKeyValueError = "key=";
        assertThatThrownBy(() -> nameLoad.parse(argKeyValueError))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("value")
                .hasMessageContaining(argKeyValueError);
    }
}