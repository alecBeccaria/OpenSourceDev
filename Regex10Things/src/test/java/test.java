import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void testValidNumber() {
        assertTrue(v.isValidPhoneNumber("307-388-0772"));
        assertTrue(v.isValidPhoneNumber("1-307-388-0772"));
        assertTrue(v.isValidPhoneNumber("11-307-388-0772"));
        assertFalse(v.isValidPhoneNumber("11-307-3883-0772"));
    }

    @Test
    void testValidSSN() {
        assertTrue(v.isValidSSN("893873453"));
        assertFalse(v.isValidSSN("000000000"));
    }

    @Test
    void testValidUSAddress() {
        assertTrue(v.isValidUSStreetAddress("556 E 300 S Apt# 313\n" +
                "Salt Lake City, UT 84102-4087"));
        assertTrue(v.isValidUSStreetAddress("856 Park Ave\n" +
                "Worland, WY 82401"));
        assertFalse(v.isValidUSStreetAddress("856 Park Ave\n" +
                "Worland WY 8201-"));
    }

    @Test
    void testPasswordComplexity() {
        assertTrue(v.validatePasswordComplexity("Tortilla2255!", 8, 1, 7, 2, 1));
    }

    @Test
    void testCountContains(){
        assertEquals(6, v.countContains("yes", "yes no yes yes no yes no yes yes"));

    }
    @Test
    void testHTMLTagContents(){
        assertTrue(v.getHTMLTagContents("<h1>My First Heading</h1>", "h1").equals("My First Heading"));
    }

    @Test
    void testHTMLTagsContents() {
        String[] str = new String[1];
        str = v.getHTMLTagsContents("<h1 href='link'>yes</h1>", "h1");

       assertTrue(str[0].equals(" href='link'"));
    }

    @Test
    void testHTMLURL(){
        String HTML = "<h2>Absolute URLs</h2>\n" +
                "<p><a href=\"https://www.w3.org/\">W3C</a></p>\n" +
                "<p><a href=\"https://www.google.com/\">Google</a></p>\n" +
                "\n" +
                "<h2>Relative URLs</h2>\n" +
                "<p><a href=\"html_images.asp\">HTML Images</a></p>\n" +
                "<p><a href=\"/css/default.asp\">CSS Tutorial</a></p>";
        String[] str = new String[1];
        str = v.getHTMLLinkURL(HTML);
        System.out.println(Arrays.toString(str));
        assertTrue(str[0].equals("https://www.w3.org/"));
    }
}
