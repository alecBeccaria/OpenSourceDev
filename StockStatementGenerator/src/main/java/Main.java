import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

    }

    public static void readJSON() {
        try{
            Object json = new JSONParser().parse(new FileReader("data\\stocks.json"));
            JSONArray jsonA = (JSONArray) json;

        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}