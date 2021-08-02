import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Validate v = new Validate();
        //v.isValidHumanName("Miss. Tina Moore");
        //v.countContains("Alec", "Alec, you are cool, Alec is awesome");
        //v.getHTMLTagContents("<html>", "html" );
        String[] str = new String[1];

        str = v.getHTMLTagsContents("<h1 href='link'>yes</h1>", "h1");
        System.out.println(str[0]);

        boolean valid = v.validatePasswordComplexity("Tortilla!", 8, 1, 7, 2, 1);
        System.out.println(valid);

        String HTML = "<h2>Absolute URLs</h2>\n" +
                "<p><a href=\"https://www.w3.org/\">W3C</a></p>\n" +
                "<p><a href=\"https://www.google.com/\">Google</a></p>\n" +
                "\n" +
                "<h2>Relative URLs</h2>\n" +
                "<p><a href=\"html_images.asp\">HTML Images</a></p>\n" +
                "<p><a href=\"/css/default.asp\">CSS Tutorial</a></p>";
        System.out.println(Arrays.toString(v.getHTMLLinkURL(HTML)));
    }
}
