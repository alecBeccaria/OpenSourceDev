import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class test {
    Validate v = new Validate();

    @Test
    void testValidName() {
        assertTrue(v.isValidHumanName("Mr. Alec Sebastian Beccaria"));
        assertFalse(v.isValidHumanName("Mr. alec Beccaria"));

    }

    @Test
    void testValidEmail() {
        assertTrue(v.isValidEmailAddress("email@address.com"));
        assertFalse(v.isValidEmailAddress("675@address.com"));

    }

    @Test
    void testValidSSN() {
        assertTrue(v.isValidSSN("893873453"));
        assertFalse(v.isValidSSN("000000000"));
    }
}
