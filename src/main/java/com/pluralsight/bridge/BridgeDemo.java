//package main.java.com.pluralsight.bridge;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class BridgeDemo {
//
//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement sta = null;
//        try {
//            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
//            String dbUrl = "jdbc:derby:codejava/webdb;create=true";
//
//            conn = DriverManager.getConnection(dbUrl);
//            sta = conn.createStatement();
//
//            sta.executeUpdate("CREATE TABLE Addresss (ID INT, StreetName VARCHAR (20), City VARCHAR (20))");
//            System.out.println("Table created");
//
//            sta.executeUpdate("DROP TABLE Addresss");
//            System.out.println("Table dropped successfully");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (sta != null)
//                    conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
