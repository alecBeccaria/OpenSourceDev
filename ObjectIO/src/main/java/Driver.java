import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;

public class Driver {
    //Reads the CSV and converts it to a ArrayList
    public static ArrayList<Person> readCSV(String file){
        ArrayList<Person> personList = new ArrayList<>();
        try{

            FileReader fileReader = new FileReader(file);
            CSVReader readCSV = new CSVReader(fileReader);
            String[] nextRecord;
            while ((nextRecord = readCSV.readNext()) != null){
                Person person = new Person(Arrays.toString(nextRecord));
                if(!(person.getFullName() == null)) {
                    personList.add(person);

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return personList;
    }

    //Takes ArrayList and serializes the file
    public static void WriteItEmp(ArrayList<Person> peopleList) {
        try {
            FileOutputStream fos = new FileOutputStream("Data\\outputEmp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(peopleList);
            oos.close();
            fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    //Looks for target file, and deserializes
    public static void InputItEmp() {
        ArrayList<Person> people = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("Data\\outputEmp.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            people = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        for (Person person : people) {
            System.out.println(person);
        }

    }

}