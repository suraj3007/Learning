package main.java.com.pluralsight.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventorySystem {

    private final Catalog catalog = new Catalog();
    private final List<Order> orders = new CopyOnWriteArrayList();

    /**
     * Take order.
     * It will lookup in the map whether item is present or not.
     * If present, then it will return the same Item object. Else new Item object will be created.
     * Based on lookup, new Order will be placed and added into the order list
     * @param itemName
     * @param orderNumber
     */
    void takeOrder(String itemName, String orderNumber) {
        Item item = catalog.lookup(itemName);
        Order order =  new Order(orderNumber, item);
        orders.add(order);
    }

    /**
     * Process each order and removes from the order list
     */
    void process() {
        System.out.println("Total no. of orders : " + orders.size());
        for (Order order : orders){
            order.processOrder();
            orders.remove(order);
        }
    }

    //No. of items object created
    String report() {
        return "\nTotal Item objects made : " +
                catalog.totalItemsMade();
    }

}
