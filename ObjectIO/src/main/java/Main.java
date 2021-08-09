import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = Driver.readCSV("Data\\people.to.regex.csv");
        Driver.WriteItEmp(people);
        Driver.InputItEmp();
    }
}
