//package main.java.com.pluralsight.facade;
//
//import main.java.com.pluralsight.singleton.DbSingletonDerby;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Facade pattern :
// * Different method for different type of operations
// * create, insert, fetch and drop operations
// */
//public class JdbcFacade {
//    DbSingletonDerby instance = null;
//
//    public JdbcFacade() {
//        instance = DbSingletonDerby.getInstance();
//    }
//
//    public int createTable() {
//        int count = 0;
//        try {
//            Connection conn = instance.getConn();
//            Statement sta = conn.createStatement();
//
//            count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR (20), City VARCHAR (20))");
//
//            sta.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return count;
//    }
//
//    public int insertIntoTable() {
//        int count = 0;
//        try {
//            Connection conn = instance.getConn();
//            Statement sta = conn.createStatement();
//
//            count = sta.executeUpdate("Insert INTO Address (ID, StreetName, City) " +
//                    "VALUES (123, 'Virar', 'Mumbai')");
//
//            sta.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return count;
//    }
//
//    public List<Address> getAddresses() {
//        List<Address> addresses = new ArrayList<>();
//        try {
//            Connection conn = instance.getConn();
//            Statement sta = conn.createStatement();
//
//            ResultSet rs = sta.executeQuery("SELECT * FROM Address");
//
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + " " + rs.getString(2) +
//                        " " + rs.getString(3));
//
//                Address address = new Address();
//                address.setId(rs.getString(1));
//                address.setStreetName(rs.getString(2));
//                address.setCity(rs.getString(3));
//
//                addresses.add(address);
//            }
//
//            rs.close();
//            sta.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return addresses;
//    }
//
//    public void dropTable() {
//        try {
//            Connection conn = instance.getConn();
//            Statement sta = conn.createStatement();
//
//            sta.executeUpdate("DROP TABLE Address");
//
//            sta.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//class Address {
//
//    public String id;
//    public String streetName;
//    public String city;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getStreetName() {
//        return streetName;
//    }
//
//    public void setStreetName(String streetName) {
//        this.streetName = streetName;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//}
