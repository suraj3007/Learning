package main.java.com.pluralsight.decorator;

//Concrete class implements root
public class SimpleSandwich implements Sandwich {

    @Override
    public String make() {
        return "bread";
    }
}
