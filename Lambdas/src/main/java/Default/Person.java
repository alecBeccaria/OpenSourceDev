package Default;

public class Person {
    private String strName;
    private String strSSN;
    private String strEmail;
    private String strStreet;
    private String strCity;
    private String strState;
    private String strZip;
    private String strPhone;

    public String getPhone() {
        return strPhone;
    }

    public void setPhone(String strPhone) {
        this.strPhone = strPhone;
    }

    public String getName() {
        return strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getSSN() {
        return strSSN;
    }

    public void setSSN(String strSSN) {
        this.strSSN = strSSN;
    }

    public String getEmail() {
        return strEmail;
    }

    public void setEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStreet() {
        return strStreet;
    }

    public void setStreet(String strStreet) {
        this.strStreet = strStreet;
    }

    public String getCity() {
        return strCity;
    }

    public void setCity(String strCity) {
        this.strCity = strCity;
    }

    public String getState() {
        return strState;
    }

    public void setState(String strState) {
        this.strState = strState;
    }

    public String getZip() {
        return strZip;
    }

    public void setZip(String strZip) {
        this.strZip = strZip;
    }

    @Override
    public String toString() {
        return this.strName + " " + this.strState;
    }
}
