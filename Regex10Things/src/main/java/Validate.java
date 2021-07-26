import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate implements RegexUtility {

    private Matcher MatchyMatchy(String strLine, String strRegex) {

        Pattern p;
        Matcher m;

        p = Pattern.compile(strRegex);
        m = p.matcher(strLine);

        return m;
    }


    @Override
    public boolean isValidHumanName(String name) {
        String regex = "([A-Z]\\w*). ?([A-Z]\\w*) ?([A-Z]\\w*)? ([A-Z]\\w*)";
        Matcher matchy = MatchyMatchy(name, regex);
        if(matchy.find()) {
            System.out.println(name + "\nThis name is in Correct format");
            return true;
        }else {
            System.out.println(name + "\nThis name is not in correct format");
            return false;
        }

    }

    @Override
    public boolean isValidEmailAddress(String email) {
        String regex = "^([A-Za-z][\\w*.-]+@[A-Za-z][\\w*.-]+\\.[\\w*-]+)";
        Matcher matchy = MatchyMatchy(email, regex);
        if(matchy.find()) {
            System.out.println(email + "\nThis email is in Correct format");
            return true;
        }else {
            System.out.println(email + "\nThis email is not in correct format");
            return false;
        }
    }

    @Override
    public boolean isValidPhoneNumber(String phone) {
        String regex = "([1-9][\\d]?-)?(\\d{3})-(\\d{3})-(\\d{4})";
        Matcher matchy = MatchyMatchy(phone, regex);
        if(matchy.find()) {
            System.out.println(phone + "\nThis phone number is in Correct format");
            return true;
        }else {
            System.out.println(phone + "\nThis phone number is not in correct format");
            return false;
        }
    }

    @Override
    public boolean isValidSSN(String ssn) {
        String regex = "^([1-9]{3})(\\d[1-9])(\\d{3}[1-9])";
        Matcher matchy = MatchyMatchy(ssn, regex);
        if(matchy.find()) {
            System.out.println(ssn + "\nThis ssn is in Correct format");
            return true;
        }else {
            System.out.println(ssn + "\nThis ssn number is not in correct format");
            return false;
        }
    }

    @Override
    public boolean isValidUSStreetAddress(String street) {
        return false;
    }

    @Override
    public boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols) {
        return false;
    }

    @Override
    public int countContains(String needle, String haystack) {
        return 0;
    }

    @Override
    public String getHTMLTagContents(String html, String tagName) {
        return null;
    }

    @Override
    public String[] getHTMLTagsContents(String html, String tagName) {
        return new String[0];
    }

    @Override
    public String[] getHTMLLinkURL(String html) {
        return new String[0];
    }
}
