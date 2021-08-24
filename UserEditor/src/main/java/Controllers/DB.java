package Controllers;

import java.sql.*;

public class DB {
    private static String url = "jdbc:mysql://localhost:3306/"
            + "People?allowPublicKeyRetrieval=true&useSSL=false";
    private static String user = "root";
    private static String password = "root";

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


    public static void selectPersonID(int id) {
        //String sql = "Select * from Authors where id= " + 1;
        String sql = "Select * from people where PersonID= (?)";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            pst.setInt(1, id);
            pst.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectPersonAccount(String inPassword, String userName) {
        //String sql = "Select * from Authors where id= " + 1;

        try  {
            String sql = "Select FirstName, LastName, UserName, Email, UserPassword from people where UserName=? and UserPassword=?";
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,userName);
            pst.setString(2,inPassword);
            return pst.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateBook(String title, int id) {
        String sql = "UPDATE person SET Title = (?) Where id=(?)";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, title);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertPerson(String FirstName, String LastName, String UserName, String Email, String UserPassword) {
        String sql = "INSERT INTO people (FirstName, LastName, UserName, Email, UserPassword) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, FirstName);
            pst.setString(2, LastName);
            pst.setString(3, UserName);
            pst.setString(4, Email);
            pst.setString(5, UserPassword);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePerson(int strBookID) {
        String sql = "DELETE FROM People WHERE id=(?)";
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


}
