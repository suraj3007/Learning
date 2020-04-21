package main.java.com.pluralsight.factoryMethod;

import java.util.Calendar;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.YEAR));
    }
}
