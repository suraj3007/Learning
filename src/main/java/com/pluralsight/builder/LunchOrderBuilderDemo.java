package main.java.com.pluralsight.builder;

public class LunchOrderBuilderDemo {

    public static void main(String[] args) {

        LunchOrderBuilder.Builder builder = new LunchOrderBuilder.Builder();

        builder.bread("Wheat").condiments("Lettuce").dressing("Mustard").meat("Ham");

//        builder.bread("Wheat").condiments("Lettuce").meat("Ham");  -> Any combination we can use. Hence, overcomes Telescopping Constructors

        /**
         * The objects are immutable as no setter method is present.
         * So, we cant change the state of an object.
         */
//        orderTele.setBread("Wheat");
//        orderTele.setCondiments("Lettuce");
//        orderTele.setDressing("Mustard");
//        orderTele.setMeat("Hem");

        LunchOrderBuilder lunchOrder = builder.build();

        //LunchOrderBuilder lunchOrder = builder.bread("Wheat").condiments("Lettuce").dressing("Mustard").meat("Ham").build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }
}
