package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array)
                .hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkArrayMethod() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "four", "five");
        assertThat(array)
                .isNotEmpty()
                .hasSize(3)
                .contains("four", Index.atIndex(1))
                .endsWith("five");
    }

    @Test
    void checkToListMethod() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list)
                .isNotNull()
                .hasSize(5)
                .allSatisfy(e -> {
                    assertThat(e).isNotBlank();
                    assertThat(e).isNotEqualTo("zero");
                })
                .contains("first", "four", "five");
    }

    @Test
    void checkToSetMethod() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set)
                .isNotEmpty()
                .hasSize(5)
                .allMatch(e -> e.length() < 7)
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five");

    }

    @Test
    void checkToMapMethod() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map)
                .isNotNull()
                .hasSize(5)
                .containsKeys("first", "three")
                .containsValues(3, 4)
                .doesNotContainKey("eleven")
                .doesNotContainValue(11)
                .containsEntry("four", 3);
    }
}