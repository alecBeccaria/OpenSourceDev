

public class LargeEmployee extends prog.Employee {
    public byte[] SomeData;

    public LargeEmployee(int id, String firstName, String lastName, int hireYear, byte[] someData) {
        super(id, firstName, lastName, hireYear);
        SomeData = someData;
    }


}
