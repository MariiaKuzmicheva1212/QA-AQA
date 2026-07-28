package lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testFactorial() {
        // Проверяем основные случаи
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
        assertEquals(3628800, FactorialCalculator.calculateFactorial(10));

        // Проверяем ошибку
        assertEquals(-1, FactorialCalculator.calculateFactorial(-5));
    }
}