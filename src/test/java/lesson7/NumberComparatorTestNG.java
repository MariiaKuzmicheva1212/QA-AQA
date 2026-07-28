package lesson7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {

    @Test
    public void testCompareNumbers() {
        // Проверяем все варианты
        assertEquals(NumberComparator.compareNumbers(5, 10), "<");
        assertEquals(NumberComparator.compareNumbers(10, 5), ">");
        assertEquals(NumberComparator.compareNumbers(7, 7), "=");

        // Проверяем отрицательные
        assertEquals(NumberComparator.compareNumbers(-10, -5), "<");
        assertEquals(NumberComparator.compareNumbers(-5, -10), ">");
        assertEquals(NumberComparator.compareNumbers(-7, -7), "=");

        // Проверяем с нулём
        assertEquals(NumberComparator.compareNumbers(-5, 0), "<");
        assertEquals(NumberComparator.compareNumbers(5, 0), ">");
        assertEquals(NumberComparator.compareNumbers(0, 0), "=");
    }
}
