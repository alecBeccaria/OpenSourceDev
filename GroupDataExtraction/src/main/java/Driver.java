import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {


    public static boolean readCSV(String file){
        boolean valid = false;
        try{
            List<Person> personList = new ArrayList<>();
            FileReader fileReader = new FileReader(file);
            CSVReader readCSV = new CSVReader(fileReader);
            String[] nextRecord;
            while ((nextRecord = readCSV.readNext()) != null){
                Person person = new Person(Arrays.toString(nextRecord));
                if(!(person.getFullName() == null)) {
                    personList.add(person);
                    valid = true;
                }
            }
            System.out.println(personList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return valid;
    }
}
