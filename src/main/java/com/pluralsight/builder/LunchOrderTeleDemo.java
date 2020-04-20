package main.java.com.pluralsight.builder;

public class LunchOrderTeleDemo {

    public static void main(String[] args) {

        LunchOrderTele orderTele = new LunchOrderTele("Wheat", "Lettuce", "Mustard", "Ham");

        //Bcoz we dont have constructor for this combination.
        LunchOrderTele orderTele1 = new LunchOrderTele("Wheat", "Lettuce", null, "Ham");

        /**
         * However, Telescopping Constructors solves the problem of object mutability.
         * In this case, the objects are immutable as no setter method is present.
         * So, we cant change the state of an object.
         */
//        orderTele.setBread("Wheat");
//        orderTele.setCondiments("Lettuce");
//        orderTele.setDressing("Mustard");
//        orderTele.setMeat("Hem");

        System.out.println(orderTele.getBread());
        System.out.println(orderTele.getCondiments());
        System.out.println(orderTele.getDressing());
        System.out.println(orderTele.getMeat());

        System.out.println("---------------------------------------------------------------------");

        System.out.println(orderTele1.getBread());
        System.out.println(orderTele1.getCondiments());
        System.out.println(orderTele1.getDressing());
        System.out.println(orderTele1.getMeat());

    }
}
