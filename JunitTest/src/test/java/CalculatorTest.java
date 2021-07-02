import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    void addition() {
        Calculator calculator = new Calculator();
        int value = calculator.addition(50, 50);
        assertEquals(100, value);
    }

    @Test
    void subtraction() {
        Calculator calculator = new Calculator();
        int value = calculator.subtraction(100, 50);
        assertEquals(50, value);
    }

    @Test
    void multiplication() {
        Calculator calculator = new Calculator();
        int value = calculator.multiplication(10, 2);
        assertEquals(20, value);
    }

    @Test
    void division() {
        Calculator calculator = new Calculator();
        float value = calculator.division(5, 2);
        assertEquals(2.5f, value);
    }
}