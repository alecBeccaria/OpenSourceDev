package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheStart {

    public static void main(String[] args) {
        DB.testConnection();
        String strURL = "https://nytimes.com";
        String strInputLine = "", strTotalSource = "";

        try {

            URL url = new URL(strURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            BufferedReader br = new BufferedReader
                    (new InputStreamReader(conn.getInputStream()));

            while ((strInputLine = br.readLine()) != null) {
                strTotalSource += strInputLine + "\n";

            }
            br.close();
            //System.out.println(strTotalSource);

            //Pattern p = Pattern.compile("<title[^>]*>(.+?)</title>");
            Pattern p = Pattern.compile("<a (.+?)href=\"(.+?)\"(.+?)>(.+?)</a>");
            Matcher m = p.matcher(strTotalSource);
            StringBuilder sb = new StringBuilder();
            while(m.find())
            {
                sb.append(m.group(2));
                System.out.println(m.group(2));
            }
            DB.insertContent(sb.toString(), strURL);


        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}