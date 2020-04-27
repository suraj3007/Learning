package main.java.com.pluralsight.facade;

import main.java.com.pluralsight.singleton.DbSingletonDerby;

import java.sql.*;

/**
 * Without Facade pattern, the client is getting heavier.
 * Create, fetch and insert operations are performed and there is no abstraction.
 * Code visibilty is there that we are using Singleton pattern  and what different spl statement we are exceuting
 */
public class JdbcwithoutFacade {

    public static void main(String[] args) {
        DbSingletonDerby instance = DbSingletonDerby.getInstance();
        try{
            Connection conn = instance.getConn();
            Statement sta = conn.createStatement();

            //Create table
            sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR (20), City VARCHAR (20))");
            System.out.println("Table created..");
            sta.close();

            //Insert into table
            sta = conn.createStatement();
            int count = sta.executeUpdate("Insert INTO Address (ID, StreetName, City) " +
                    "VALUES (123, 'Virar', 'Mumbai')");
            System.out.println(count + " record(s) created");
            sta.close();

            //Fetch from table
            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Address");

            while (rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) +
                " " + rs.getString(3));
            }
            sta.close();

            //Drop table
            sta = conn.createStatement();
            sta.executeUpdate("DROP TABLE Address");
            System.out.println("Table dropped successfully");
            sta.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
