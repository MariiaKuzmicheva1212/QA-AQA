package lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {

    @Test
    void testTriangleCalculator() {

        assertTrue(TriangleAreaCalculator.isValidTriangle(3, 4, 5));
        assertTrue(TriangleAreaCalculator.isValidTriangle(5, 5, 5));
        assertFalse(TriangleAreaCalculator.isValidTriangle(1, 1, 3));
        assertFalse(TriangleAreaCalculator.isValidTriangle(1, 2, 3));

        assertEquals(6.0, TriangleAreaCalculator.calculateArea(3, 4, 5), 0.001);
        assertEquals(10.825, TriangleAreaCalculator.calculateArea(5, 5, 5), 0.001);
        assertEquals(24.0, TriangleAreaCalculator.calculateArea(6, 8, 10), 0.001);

        assertEquals(-1.0, TriangleAreaCalculator.calculateArea(1, 1, 3), 0.001);
        assertEquals(-1.0, TriangleAreaCalculator.calculateArea(-3, 4, 5), 0.001);
    }
}