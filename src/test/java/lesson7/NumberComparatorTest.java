package lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void testCompareNumbers() {
        assertEquals("<", NumberComparator.compareNumbers(5, 10));
        assertEquals(">", NumberComparator.compareNumbers(10, 5));
        assertEquals("=", NumberComparator.compareNumbers(7, 7));

        assertEquals("<", NumberComparator.compareNumbers(-10, -5));
        assertEquals(">", NumberComparator.compareNumbers(-5, -10));
        assertEquals("=", NumberComparator.compareNumbers(-7, -7));

        assertEquals("<", NumberComparator.compareNumbers(-5, 0));
        assertEquals(">", NumberComparator.compareNumbers(5, 0));
        assertEquals("=", NumberComparator.compareNumbers(0, 0));
    }
}