import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {
    @Test
    void testForHTML() {
        try{
            for(int i = 0; i < 2; i++){
                Object json = new JSONParser().parse(new FileReader("data\\stocks.json"));
                JSONArray jsonA = (JSONArray) json;
                JSONObject customerRecord = (JSONObject)  jsonA.get(i);
                Main.writeHTML(customerRecord, , 0, 0);
                assertTrue(Main.writeHTML(customerRecord, null, 0, 0));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Test
    void testForPDF() {

    }

    @Test
    void testValues() {

    }
}
