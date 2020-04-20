package main.java.com.pluralsight.builder;

public class LunchOrderBeanDemo {

    public static void main(String[] args) {

        LunchOrderBean orderBean = new LunchOrderBean();

        /**
         * Here, we have to set each variable by using setter method which increase the LOC.
         * Also, the value of an object can be changed by using the setter method. Hence object mutable
         */
        orderBean.setBread("Wheat");
        orderBean.setCondiments("Lettuce");
        orderBean.setDressing("Mustard");
        orderBean.setMeat("Hem");

        System.out.println(orderBean.getBread());
        System.out.println(orderBean.getCondiments());
        System.out.println(orderBean.getDressing());
        System.out.println(orderBean.getMeat());
    }
}
