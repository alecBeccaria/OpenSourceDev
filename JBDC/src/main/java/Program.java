import java.sql.*;
import java.util.*;

public class Program {
    static String url = "jdbc:mysql://localhost:3306/"
            + "testdb?allowPublicKeyRetrieval=true&useSSL=false";
    static String user = "root";
    static String password = "test";

    public static void testConnection(){
        String sql = "SELECT VERSION()";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectAuthorsST(){
        //String sql = "Select * from Authors where id= " + 1;
        String sql = "Select id, name from Authors";

        try  (Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateBook(){
        String sql = "UPDATE Books SET Title = 'Crime & Punishment' Where id=2";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertBook(){
        String sql = "INSERT INTO Authors(Name) Values('Brandon Sanderson')";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
