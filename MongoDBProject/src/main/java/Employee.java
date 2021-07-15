

import java.io.Serializable;

public class Employee implements Serializable {
    private int id = 0;
    private String firstName = "";
    private String lastName = "";
    private int hireYear = 0;


    public Employee(int id, String firstName, String lastName, int hireYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireYear = hireYear;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", hireYear=" + hireYear +
                '}';
    }


}
