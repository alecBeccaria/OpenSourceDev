import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.apache.commons.math3.util.Precision;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        readJSON();
    }

    public static void writeHTML(JSONObject customerRecord, StringBuilder strHTMLTableTradeTop, double cashValue, double stockValue) {
        String strHTMLTop = "<!DOCTYPE html><html><body><br></br>";
        String strHTMLBottom = "</body></html>";
        String strHTMLCustInfo = String.format("<h1>%s</h1><p>%s %s</p>"
                +"<p>%s</p>\r\n", LocalDate.now(), customerRecord.get("first_name"), customerRecord.get("last_name"), customerRecord.get("ssn"));
        String strHTMLSummary = String.format("<p>Cash Value: " + cashValue  + "</p>\r\n<p> Stock Value: " + stockValue
        + "</p>\r\n", "cash", "stock");

        String strHTMLTableTradeBottom = "</table>";
        String strHTMLAccountBalance = "<br>Starting Balance: " + customerRecord.get("beginning_balance") + "</br>";
        String strFileName = customerRecord.get("account_number").toString();

        FileWriter fw;

        try {
            fw = new FileWriter("data\\" + strFileName + ".html");
            fw.write(strHTMLTop);
            fw.write(strHTMLCustInfo);
            fw.write(strHTMLTableTradeTop.toString());
            fw.write(strHTMLTableTradeBottom);
            fw.write(strHTMLAccountBalance);
            fw.write(strHTMLSummary);
            fw.write(strHTMLBottom);
            fw.close();
            createPDF(strFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createPDF(String strFileName) {

        try {
            File inFile = new File("data\\" + strFileName + ".html");
            System.out.println("file=" + inFile.getAbsolutePath());
            File outFile = new File("data\\" + strFileName + ".pdf");

            //inFile and outFile are java.io.File objects
            OutputStream os = new FileOutputStream(outFile);
            PdfRendererBuilder builder = new PdfRendererBuilder();

            builder.useFastMode();
            builder.withFile(inFile);
            builder.toStream(os);
            builder.run();
        } catch (Exception e) {
            //System.out.println(e.toString());
            e.printStackTrace();
        }
    }


    public static void readJSON() {
        try{

            Object json = new JSONParser().parse(new FileReader("data\\stocks.json"));
            JSONArray jsonA = (JSONArray) json;

            for(int i = 0; i < 10; i++)
            {
                StringBuilder strHTMLTableTradeTop = new StringBuilder("<table style='100%' border='2'>\r\n" +
                        "<tr>" +
                        "<th>Type</th>" +
                        "<th>Symbol</th>" +
                        "<th>Price</th>" +
                        "<th>Shares</th>" +
                        "<th>Total</th></tr>");
                JSONObject customerRecord = (JSONObject)  jsonA.get(i);
                String stringCash = (String) customerRecord.get("beginning_balance");
                double cashValue = Double.parseDouble(stringCash.substring(1));
                double stockValue = 0;

                JSONArray trades = (JSONArray) customerRecord.get("stock_trades");
                for (Object o : trades) {
                    JSONObject trade = (JSONObject) o;
                    String stockPriceStr = (String) trade.get("price_per_share");
                    float stockPrice = Float.parseFloat(stockPriceStr.substring(1));
                    long shares = (long) trade.get("count_shares");
                    String temp = (String) trade.get("type");
                    double shareTotal = stockPrice * shares;
                    if (temp.equals("Buy")){
                        cashValue -= shareTotal;
                        stockValue += shareTotal;
                    }
                    else {
                        cashValue = cashValue + shareTotal;
                        stockValue = stockValue - shareTotal;
                    }

                    strHTMLTableTradeTop.append("<tr><td align='center'>" + trade.get("type") + "</td>");
                    strHTMLTableTradeTop.append("<td align='center'>" + trade.get("stock_symbol") +"</td>");
                    strHTMLTableTradeTop.append("<td align='center'>" + trade.get("price_per_share") + "</td>");
                    strHTMLTableTradeTop.append("<td align='center'>" + trade.get("count_shares") + "</td>");
                    strHTMLTableTradeTop.append("<td align='center'>" + shareTotal + "</td></tr>");

                }
                writeHTML(customerRecord, strHTMLTableTradeTop, Precision.round(cashValue, 2), Precision.round(stockValue, 2));
            }

        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}