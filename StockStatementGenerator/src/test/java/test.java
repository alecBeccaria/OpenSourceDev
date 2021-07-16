import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    void testForHTML() {
        try{
            Object json = new JSONParser().parse(new FileReader("data\\stocks.json"));
            for(int i = 0; i < 10; i++){
                JSONArray jsonA = (JSONArray) json;
                JSONObject customerRecord = (JSONObject)  jsonA.get(i);
                String strFileName = customerRecord.get("account_number").toString();
                Main.writeHTML(customerRecord, null, 0, 0);
                File f = new File("data\\" + strFileName + ".html");
                int testNum = 0;
                if(f.exists() && !f.isDirectory()) {
                    testNum = 1;

                }
                assertEquals(1, testNum);
            }

        }catch (Exception e) {
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
