package main.java.com.pluralsight.flyweight;

/**
 * Consider an inventory system such as Amazon.
 * They cant create object for each item for multiple users.
 * One item object is created and shared the same object with all users.
 * Based on user places order, a new order is created for same item
 */
public class FlyweightDemo2 {

    public static void main(String[] args) {
        InventorySystem ims = new InventorySystem();

        ims.takeOrder("Roomba", "221");
        ims.takeOrder("Samsung TV", "445");
        ims.takeOrder("Boss headphone", "776");
        ims.takeOrder("Roomba", "335");
        ims.takeOrder("Boss headphone", "878");
        ims.takeOrder("Samsung TV", "910");
        ims.takeOrder("Boss headphone", "111");
        ims.takeOrder("Roomba", "673");
        ims.takeOrder("Boss headphone", "457");
        ims.takeOrder("Samsung TV", "552");
        ims.takeOrder("Boss headphone", "897");

        ims.process();

        System.out.println(ims.report());
    }
}
