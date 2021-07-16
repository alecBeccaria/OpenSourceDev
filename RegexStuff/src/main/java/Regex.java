import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Regex {
    public static void main(String[] args) {
        RegExRunner("aaa568 nnn568", "\\d{3}");
    }

    public static void RegExRunner(String strSearch, String strRegex) {
        System.out.println("--> Searching: '" + strSearch + "' "
        + "regex: '" + strRegex + "'");

        Pattern p = Pattern.compile(strRegex);
        Matcher m = p.matcher(strSearch);

        int intMatchCount = 0;

        while(m.find()) {
            intMatchCount++;
            System.out.println("Match# "+ intMatchCount + " = '" + m.group() + "'");
            System.out.println("Position start: " + m.start() + ", end: " + m.end());

        }
    }
}
