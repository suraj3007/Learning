package main.java.com.pluralsight.decorator;


/**
 * Decorator demo:
 * Here we are wrapping an object inside other.
 * Each wrapping adds an additional functionality to the sandwich.
 * This adding functionality at each level defines Decorator pattern
 */
public class DecoratorDemo2 {

    public static void main(String[] args) {

        Sandwich sandwich = new SimpleSandwich();

        Sandwich sandwich1 = new DressingDecorator(new PaneerDecorator(sandwich));

        //System.out.println(sandwich.getClass());
        System.out.println(sandwich1.make());

        //We are creating different sandwich without creating the object everytime for SimpleSandwich
        Sandwich sandwich2 = new PaneerDecorator(sandwich);
        System.out.println(sandwich2.make());

        //We are creating different sandwich without creating the object everytime of SimpleSandwich
        Sandwich sandwich3 = new DressingDecorator(sandwich);
        System.out.println(sandwich3.make());
    }
}


// Dont confuse Decorator with Creational Patterns.
// Decorator is Structural pattern as we are modifying the structure by adding functionalities.