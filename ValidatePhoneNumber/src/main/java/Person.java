import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String strPhone;

    public String getPhone() {
        return strPhone;

    }

    public boolean setPhone(String inPhone) {
        boolean b = RegExRunner(inPhone, "(\\d{3})[-]\\d{3}[-]\\d{4}\\b");
        if (b){
            this.strPhone = inPhone;
            System.out.println(getPhone() + " is a correct Number");
        }else {
            throw new IllegalArgumentException("You must enter a valid # format" +
                    "\nex: 123-456-7890");
        }
        return b;

    }

    public boolean RegExRunner(String strSearch, String strRegex) {
        System.out.println("--> Searching: '" + strSearch + "' "
                + "regex: '" + strRegex + "'");
        Pattern p = Pattern.compile(strRegex);
        Matcher m = p.matcher(strSearch);
        return m.matches();
    }
}
