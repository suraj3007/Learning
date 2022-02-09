//package main.java.com.pluralsight.facade;
//
//import java.util.List;
//
///**
// * With Facade pattern: -
// * Client side is light weight.
// * Implementation logic is unknown.
// */
//public class JdbcFacadeDemo {
//
//    public static void main(String[] args) {
//
//        JdbcFacade facade = new JdbcFacade();
//
//        facade.createTable();
//        System.out.println("Table created successfully");
//
//        facade.insertIntoTable();
//        System.out.println("Records inserted");
//
//        List<Address> addresses = facade.getAddresses();
//
//        for (Address address : addresses) {
//            System.out.println(address.getId() + " " + address.getStreetName() + " " + address.getCity());
//        }
//
//        facade.dropTable();
//        System.out.println("Table dropped successfully");
//    }
//}
