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
            for(int i = 0; i < 1; i++){
                JSONArray jsonA = (JSONArray) json;
                JSONObject customerRecord = (JSONObject)  jsonA.get(i);
                StringBuilder strHTMLTableTradeTop = new StringBuilder("test");
                assertTrue(Main.writeHTML(customerRecord, strHTMLTableTradeTop, 0, 0));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testForPDF() {
        Main.createPDF("1");
        File pdf = new File("data\\1.pdf");
        boolean test = false;
        if (pdf.isFile() && !pdf.isDirectory()) {
            test = true;
        }
        assertTrue(test);
    }
}
