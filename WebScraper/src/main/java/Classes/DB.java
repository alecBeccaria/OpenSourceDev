package Classes;
import java.sql.*;

public class DB {
    private static String strUrl = "jdbc:mysql://localhost:3306/"
            + "HTML?allowPublicKeyRetrieval=true&useSSL=false";
    private static String user = "root";
    private static String password = "root";

    public static void testConnection() {
        String sql = "SELECT VERSION()";

        try {
            Connection con = DriverManager.getConnection(strUrl, user, password);
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



    public static void updateBook(String title, int id) {
        String sql = "UPDATE person SET Title = (?) Where id=(?)";
        try {
            Connection con = DriverManager.getConnection(strUrl, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, title);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertContent(String content, String url) {
        String sql = "INSERT INTO content (webpage, content) " +
                "VALUES (?, ?)";
        try {
            Connection con = DriverManager.getConnection(strUrl, user, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, url);
            pst.setString(2, content);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePerson(int strBookID) {
        String sql = "DELETE FROM People WHERE id=(?)";
        try {
            Connection con = DriverManager.getConnection(strUrl, user, password);
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
