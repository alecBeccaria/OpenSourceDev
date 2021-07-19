import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        RegExRunner("Yes5687 Yes5689", "\\p{Upper}");
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
