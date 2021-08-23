package Controllers;

import java.sql.*;

public class DBController {
    static String url = "jdbc:mysql://localhost:3306/"
            + "People?allowPublicKeyRetrieval=true&useSSL=false";
    static String user = "root";
    static String password = "test";

    public static void testConnection() {
        String sql = "SELECT VERSION()";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println("Connection Successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectPerson(int id) {
        //String sql = "Select * from Authors where id= " + 1;
        String sql = "Select * from People where PersonID= (?)";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateBook(String title, int id) {
        String sql = "UPDATE Books SET Title = (?) Where id=(?)";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, title);
            pst.setInt(2, id);
            pst.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertPerson(String name) {
        String sql = "INSERT INTO Authors(Name) Values(?)";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(int strBookID) {
        String sql = "DELETE FROM Books WHERE id=(?)";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,strBookID);
            pst.executeUpdate();
            //st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectAuthors(int intAuthorID, String strName) {
        //String sql = "Select * from Authors where id= " + 1;
        String sql = "Select * from Authors where id =(?) and name=(?)";

        try  {
            Connection con = DriverManager.getConnection(url, user, password);
            //Statement st = con.createStatement();
            PreparedStatement pst = con.prepareStatement(sql);
            //ResultSet rs = st.executeQuery(sql);
            ResultSet rs = pst.executeQuery(sql);
            pst.setInt(1,intAuthorID);
            pst.setString(2,strName);
            pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
