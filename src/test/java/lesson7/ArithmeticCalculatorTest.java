package lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticCalculatorTest {

    @Test
    void testCalculate() {
        assertEquals(8.0, ArithmeticCalculator.calculate(5, '+', 3), 0.001);

        assertTrue(Double.isNaN(ArithmeticCalculator.calculate(10, '/', 0)));

        assertTrue(Double.isNaN(ArithmeticCalculator.calculate(5, '%', 3)));
    }
}
