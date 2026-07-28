package lesson7;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticCalculatorTestNG {

    @Test
    public void testAddition() {
        double result = ArithmeticCalculator.calculate(5, '+', 3);
        assertEquals(result, 8.0, 0.001, "5 + 3 = 8");
    }

    @Test
    public void testSubtraction() {
        double result = ArithmeticCalculator.calculate(5, '-', 3);
        assertEquals(result, 2.0, 0.001, "5 - 3 = 2");
    }

    @Test
    public void testMultiplication() {
        double result = ArithmeticCalculator.calculate(5, '*', 3);
        assertEquals(result, 15.0, 0.001, "5 * 3 = 15");
    }

    @Test
    public void testDivision() {
        double result = ArithmeticCalculator.calculate(15, '/', 3);
        assertEquals(result, 5.0, 0.001, "15 / 3 = 5");
    }

    @Test
    public void testDivisionByZero() {
        double result = ArithmeticCalculator.calculate(10, '/', 0);
        assertTrue(Double.isNaN(result), "Деление на ноль -> NaN");
    }

    @Test
    public void testInvalidOperation() {
        double result = ArithmeticCalculator.calculate(5, '%', 3);
        assertTrue(Double.isNaN(result), "Неверная операция -> NaN");
    }
}


