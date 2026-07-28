
package lesson7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaCalculatorTestNG {

    @Test
    public void testTriangleCalculator() {

        assertTrue(TriangleAreaCalculator.isValidTriangle(3, 4, 5));
        assertFalse(TriangleAreaCalculator.isValidTriangle(1, 1, 3));

        assertEquals(TriangleAreaCalculator.calculateArea(3, 4, 5), 6.0, 0.001);
        assertEquals(TriangleAreaCalculator.calculateArea(5, 5, 5), 10.825, 0.001);

        assertEquals(TriangleAreaCalculator.calculateArea(1, 1, 3), -1.0, 0.001);
        assertEquals(TriangleAreaCalculator.calculateArea(-3, 4, 5), -1.0, 0.001);
    }
}
