package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void whenVertex4ThenTetrahedron() {
        Box box = new Box(4, 5);
        assertThat(box.whatsThis())
                .isNotEmpty()
                .contains("Tetra")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void whenVertex8ThenCube() {
        Box box = new Box(8, 5);
        assertThat(box.whatsThis())
                .isNotBlank()
                .contains("ub")
                .isEqualTo("Cube");
    }

    @Test
    void whenUnknownVertexThenUnknownObject() {
        Box box = new Box(3, 5);
        assertThat(box.whatsThis())
                .startsWith("Unknown")
                .endsWith("object")
                .isEqualTo("Unknown object");
    }

    @Test
    void whenEdgeNegativeThenUnknownObject() {
        Box box = new Box(4, -1);
        assertThat(box.whatsThis())
                .isNotNull()
                .contains("nkno", "obj")
                .isEqualTo("Unknown object");
    }

    @Test
    void whenVertex4ThenNumberOfVertices() {
        Box box = new Box(4, 5);
        assertThat(box.getNumberOfVertices())
                .isNotZero()
                .isEven()
                .isEqualTo(4);
    }

    @Test
    void whenUnknownVertexThenNumberOfVerticesIsMinus1() {
        Box box = new Box(3, 5);
        assertThat(box.getNumberOfVertices())
                .isNegative()
                .isEqualTo(-1);
    }

    @Test
    void whenUnknownVertexThenIsExistFalse() {
        Box box = new Box(3, 5);
        assertThat(box.isExist())
                .isFalse();
    }

    @Test
    void whenEdgeNegativeThenIsExistFalse() {
        Box box = new Box(4, -1);
        assertThat(box.isExist())
                .isFalse();
    }

    @Test
    void whenVertex0ThenAreaIsCorrect() {
        Box box = new Box(0, 5);
        double expectedArea = 4 * Math.PI * 25;
        assertThat(box.getArea())
                .isPositive()
                .isGreaterThan(100)
                .isEqualTo(expectedArea);
    }

    @Test
    void whenVertex4ThenAreaIsCorrect() {
        Box box = new Box(4, 5);
        double expectedArea = Math.sqrt(3) * 25;
        assertThat(box.getArea())
                .isPositive()
                .isLessThan(350)
                .isEqualTo(expectedArea);
    }
}