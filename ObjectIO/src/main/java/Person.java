import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Person implements Serializable {

    private String fullName;
    private String firstName;
    private String lastName;
    private String ssn;
    private String email;
    private String phone;

    final String regexName = "(\\w*) (\\w*)";
    final String regexSSN = "\\d{3}-\\d{2}-\\d{4}";
    final String regexEmail = "\\w*@\\w*\\.[^,]+";
    final String regexPhone = "\\d{3}-\\d{3}-\\d{4}";

    public String getFullName() {
        return fullName;
    }

    private Matcher MatchyMatchy(String strLine, String strRegex) {

        Pattern p;
        Matcher m;

        p = Pattern.compile(strRegex);
        m = p.matcher(strLine);

        return m;
    }

    public void validName(Matcher m) {
        String tempFull;
        String tempFirst;
        String tempLast;
        if(m.find()) {
            tempFull = m.group();
            if(!tempFull.equals(" ssn")){
                this.fullName = tempFull;
            }

            tempFirst = m.group(1);
            if(!tempFirst.equals("")){
                this.firstName = tempFirst;
            }

            tempLast = m.group(2);
            if (!tempLast.equals("ssn")) {
                this.lastName = tempLast;
            }

        }
    }

    public void validSSN(Matcher m) {
        if(m.find()) {
            this.ssn = m.group();
        }
    }

    public void validEmail(Matcher m){
        if(m.find()) {
            this.email = m.group();
        }
    }

    public void validPhone(Matcher m){
        if(m.find()) {
            this.phone = m.group();
        }
    }

    //constructor
    Person(String line)
    {
        Matcher m;

        if(!(line==null)) {

            m = MatchyMatchy(line, regexName);
            validName(m);

            m = MatchyMatchy(line, regexSSN);
            validSSN(m);

            m = MatchyMatchy(line, regexEmail);
            validEmail(m);

            m = MatchyMatchy(line, regexPhone);
            validPhone(m);
        }
    }




    @Override
    public String toString() {
        return String.format(
                "Full Name: %s\r\nFirst Name: %s\r\nLast Name: %s\r\nSSN: %s\r\nEmail: %s\r\nPhone: %s\r\n",
                this.fullName, this.firstName, this.lastName, this.ssn, this.email, this.phone);

    }
}
