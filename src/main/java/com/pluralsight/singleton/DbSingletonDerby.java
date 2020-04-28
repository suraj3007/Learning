package main.java.com.pluralsight.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingletonDerby extends BreakSingleton2 {

    private static volatile DbSingletonDerby instance = null;     //Lazy-loading. Will not instantiate this at the startup.
    //Volatile reason is explained below.
    private static volatile Connection conn = null;

    private DbSingletonDerby() {
        try {

            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }

        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");     //To avoid new instantiation by using Reflections in java
            // Eg. BreakSingleton class
        }
    }

    public static DbSingletonDerby getInstance() {

        if (instance == null) {                                     //Will be instantiated only when called.
            synchronized (DbSingletonDerby.class) {                 //Thread-safe. For performance we have not synchronized the whole mtd
                if (instance == null) {
                    instance = new DbSingletonDerby();
                }
            }
        }
        return instance;
    }

    public Connection getConn() throws SQLException {

        if (conn == null || conn.isClosed()) {              //Make sure to have both check. (Faced a lot of issue due to absence of second check)
            synchronized (DbSingletonDerby.class) {
                if (conn == null || conn.isClosed()) {      //Make sure to have both check. (Faced a lot of issue due to absence of second check)
                    String dbUrl = "jdbc:derby:codejava/webdb;create=true";
                    try {
                        conn = DriverManager.getConnection(dbUrl);
                        System.out.println("Connection established");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();                     //To avoid new instantiation by using clone method in java
        // Eg. BreakSingleton2 class
    }

}


//If we do not make the _instance variable volatile then the Thread which is creating the instance of Singleton is not able to communicate to the other thread
//So if Thread A is creating Singleton instance and just after creation, the CPU corrupts etc, all other threads will not be able to see the value of _instance as not null and they will believe it is still assigned null
//Why does this happen?
//Because reader threads are not doing any locking and until the writer thread comes out of a synchronized block, the memory will not be synchronized and value of _instance will not be updated in main memory.
//With the Volatile keyword in Java, this is handled by Java itself and such updates will be visible by all reader threads.

//Conclusion: volatile keyword is also used to communicate the content of memory between threads.
