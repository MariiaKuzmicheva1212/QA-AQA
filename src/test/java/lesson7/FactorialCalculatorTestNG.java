package lesson7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTestNG {

    @Test
    public void testFactorial() {
            
            assertEquals(FactorialCalculator.calculateFactorial(0), 1);
            assertEquals(FactorialCalculator.calculateFactorial(1), 1);
            assertEquals(FactorialCalculator.calculateFactorial(5), 120);
            assertEquals(FactorialCalculator.calculateFactorial(10), 3628800L);
            
            assertEquals(FactorialCalculator.calculateFactorial(-5), -1);
        }
    }
