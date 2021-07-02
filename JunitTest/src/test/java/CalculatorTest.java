import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.addition(50, 50),100);
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.subtraction(100, 50), 50);
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.multiplication(10, 2), 20);
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.division(5, 2), 2.5f);
    }
}