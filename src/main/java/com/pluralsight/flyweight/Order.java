package main.java.com.pluralsight.flyweight;


public class Order {

    private final String orderNumber;   //extrinsic property of item
    private final Item item;

    public Order(String orderNumber, Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    //Processing order
    void processOrder(){
        System.out.println("Ordering items : " + item + " for order number : " + orderNumber);
    }
}
