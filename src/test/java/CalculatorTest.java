import org.junit.jupiter.api.Test;
import com.example.calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    com.example.calculator.Calculator calculator = new Calculator();

    @Test
    public void testAdd(){
        assertEquals(3.0, calculator.add(1.0, 2.0), 0.1);
    }

    @Test
    public void testSubtract(){
        assertEquals(-1.0, calculator.subtract(1.0, 2.0), 0.1);
    }

    @Test
    public void testMultiply(){
        assertEquals(2.0, calculator.multiply(1.0, 2.0), 0.1);
    }

    @Test
    public void testDivide(){
        assertEquals(1.0, calculator.divide(2.0, 2.0), 0.1);
    }
}