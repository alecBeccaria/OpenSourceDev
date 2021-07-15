import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        readJSON();
    }

    public static void writeHTML(JSONObject customerRecord) {

        String strHTMLTop = "<!DOCTYPE html><html><body>\r\n";
        String strHTMLBottom = "</body></html>";
        String strHTMLCustInfo = String.format("<h1>%s</h1><p>%s %s</p>\r\n<p>%s</p><br>",
                LocalDate.now(), customerRecord.get("first_name"), customerRecord.get("last_name"), customerRecord.get("ssn"));
        String strHTMLTableTradeTop = "<table style=\"width:100%\">\r\n<tr><th>Type</th>"
                + "<th>Symbol</th><th>Price</th><th>Shares</th><th>Total</th></tr>";
        String strHTMLTableTradeBottom = "</table>\r\n";
        String strHTMLSummary = String.format("<p>Cash Value: %s</p>\r\n<p>Stock Value:"
                + " %s</p>\r\n", "cash", "stock");
        String strFileName = customerRecord.get("account_number").toString();

        FileWriter fw;

        try {
            fw = new FileWriter("data\\" + strFileName + "1.html");
            fw.write(strHTMLTop);
            fw.write(strHTMLCustInfo);
            fw.write(strHTMLSummary);
            fw.write(strHTMLBottom);
            fw.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void readJSON() {
        try{
            Object json = new JSONParser().parse(new FileReader("data\\stocks.json"));
            JSONArray jsonA = (JSONArray) json;

            for(int i = 0; i < 6; i++)
            {
                JSONObject customerRecord = (JSONObject)  jsonA.get(i);
                writeHTML(customerRecord);
                /*//String ssn = (String) customerRecord.get("ssn");
                String email = (String) customerRecord.get("email");
                System.out.println(email);

                JSONArray trades = (JSONArray) customerRecord.get("stock_trades");
                for(int t = 0; t < trades.size(); t++)
                {
                    JSONObject trade = (JSONObject) trades.get(t);
                    String trade_type = (String) trade.get("type");
                    System.out.println(trade_type);
                }*/
            }

        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}