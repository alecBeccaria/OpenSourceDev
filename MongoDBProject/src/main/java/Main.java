

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static String path;
    public static String PathLong;
    public static void main(String[] args) {
        path = "C:\\Users\\abeccaria\\Desktop\\TheData\\people";
        PathLong = "C:\\Users\\abeccaria\\Desktop\\TheData\\people\\long";
                PrintPeopleDetails("C:\\Users\\Logan\\Desktop\\people\\simple");
                PrintEmployees("C:\\Users\\Logan\\Desktop\\people\\simple");
                AddEmployee(1,"Bob","Carter",2020);
                DeleteEmployee(1);
                UpdateEmployee(1,"Bob","John",2019);
                SerializeAllEmployees();
                GetSerializedEmployee(1);
                GetAllEmployees(PathLong + " serialized");
               PrintAllEmployees();
                PrintSerializedDetails(PathLong + " serialized");
        System.out.println(FindAllEmployeesByLastName("WILCOX"));
        System.out.println(FindEmployeeByLastName("WILCOX"));
        System.out.println(FindEmployeeById(2));
    }
    public static void PrintPeopleDetails(String path) {
        File file = new File(path);
        BufferedReader br = null;
        for (File fl : file.listFiles()) {
            try {
                br = new BufferedReader(new FileReader(fl));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String ln = null;
            try {
                ln = br.readLine();

                while (ln != null) {
                    System.out.println(ln);
                    ln = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void PrintEmployees(String path){
        File file = new File(path);
        BufferedReader br = null;
        for ( File fl : file.listFiles() ) {
            try {
                br = new BufferedReader(new FileReader(fl));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String ln = null;
            try {
                ln = br.readLine();

                while(ln != null){
                    String[] pug = ln.split(",");
                    for(int i = 0; i < pug.length; i++){
                        pug[i] = pug[i].trim();
                    }
                    Employee em = new Employee(Integer.parseInt(pug[0]),pug[1], pug[2],Integer.parseInt(pug[3]));
                    System.out.println(em.toString());
                    ln = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void AddEmployee(int id, String firstName,String  lastName, int hireYear){
        String a = path + "//long//" + id + ".txt";
        FileWriter newFile = null;
        try {
            newFile = new FileWriter(a);
            newFile.write(id + ", " + firstName + ", " + lastName + ", " + hireYear);
            newFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void DeleteEmployee(int id){
        String a = path + "//long//" + id + ".txt";
        File newFile = new File(a);
        newFile.delete();
    }
    public static void UpdateEmployee(int id,String firstName,String lastName,int hireYear){
        String a = path + "//long//" + id + ".txt";
        FileWriter newFile = null;
        try {
            newFile = new FileWriter(a);
            newFile.write(id + ", " + firstName + ", " + lastName + ", " + hireYear);
            newFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void SerializeAllEmployees(){
        String a = path + "//long";
        File file = new File(a);
        BufferedReader br = null;
        for ( File fl : file.listFiles() ) {
            try {
                br = new BufferedReader(new FileReader(fl));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String ln = null;
            try {
                ln = br.readLine();

                while(ln != null){
                    String[] pug = ln.split(",");
                    for(int i = 0; i < pug.length; i++){
                        pug[i] = pug[i].trim();
                    }
                    Employee em = new Employee(Integer.parseInt(pug[0]),pug[1], pug[2],Integer.parseInt(pug[3]));
                    File as = new File(a + " serialized//" + em.getId() + ".ser");
                    FileOutputStream fs = new FileOutputStream(as);
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(em); // 3
                    os.close();
                    ln = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static Employee GetSerializedEmployee(int id){
        Employee e = null;
        String a = path + "//long";
        File as = new File(a + " serialized//" + id + ".ser");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(as);
            ObjectInputStream ois = new ObjectInputStream(fis);
            e  = (Employee) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }
    public static Employee FindEmployeeById(int Id) {
        Employee eee = null;

        File file = new File(PathLong);
        BufferedReader br = null;
        for ( File fl : file.listFiles() ) {
            if (fl.getName().matches(Id + ".txt")) {
                try {
                    br = new BufferedReader(new FileReader(fl));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String ln = null;
                try {
                    ln = br.readLine();

                    while (ln != null) {
                        String[] pug = ln.split(",");

                        for (int i = 0; i < pug.length; i++) {
                            pug[i] = pug[i].trim();
                        }
                        eee = new Employee(Integer.parseInt(pug[0]), pug[1], pug[2], Integer.parseInt(pug[3]));
                        ln = br.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return eee;
    }
    public static Employee FindEmployeeByLastName(String lastName){
        Employee eee = null;

        File file = new File(PathLong);
        BufferedReader br = null;
        for ( File fl : file.listFiles() ) {
            try {
                br = new BufferedReader(new FileReader(fl));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String ln = null;
            try {
                ln = br.readLine();

                while (ln != null) {
                    String[] pug = ln.split(",");

                    for (int i = 0; i < pug.length; i++) {
                        pug[i] = pug[i].trim();
                    }
                    if (lastName.toLowerCase().matches(pug[2].toLowerCase())) {
                        eee = new Employee(Integer.parseInt(pug[0]), pug[1], pug[2], Integer.parseInt(pug[3]));

                        return eee;
                    }ln = br.readLine();

                }
            } catch(IOException e){
                e.printStackTrace();
            }

        }
        return eee;

    }
    public static List<Employee> FindAllEmployeesByLastName(String lastName){
        List<Employee> eee = new ArrayList<Employee>();

        File file = new File(PathLong);
        BufferedReader br = null;
        for ( File fl : file.listFiles() ) {
            try {
                br = new BufferedReader(new FileReader(fl));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String ln = null;
            try {
                ln = br.readLine();

                while (ln != null) {
                    String[] pug = ln.split(",");

                    for (int i = 0; i < pug.length; i++) {
                        pug[i] = pug[i].trim();
                    }
                    if (lastName.toLowerCase().matches(pug[2].toLowerCase())) {
                        eee.add(new Employee(Integer.parseInt(pug[0]), pug[1], pug[2], Integer.parseInt(pug[3])));
                    }
                    ln = br.readLine();

                }
            } catch(IOException e){
                e.printStackTrace();
            }

        }
        return eee;
    }
    public static void PrintSerializedDetails(String path){
        Employee e = null;

        File file = new File(path);
        for ( File fl : file.listFiles() ) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fl);
                ObjectInputStream ois = new ObjectInputStream(fis);
                e = (Employee) ois.readObject();
                System.out.println(e);
                ois.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static HashMap<Integer, Employee> GetAllEmployees(String path){
        HashMap<Integer, Employee> hm = new HashMap<>();
        File file = new File(path);
        for ( File fl : file.listFiles() ) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fl);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Employee e  = (Employee) ois.readObject();
                hm.put(e.getId(),e);
                ois.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return hm;
    }
    public static void PrintAllEmployees(){
        for (Employee eeeem:GetAllEmployees(PathLong + " serialized").values() ) {
            System.out.println(eeeem);
        }
    }

}


