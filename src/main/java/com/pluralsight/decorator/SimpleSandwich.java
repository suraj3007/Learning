package main.java.com.pluralsight.decorator;

//Concrete class implements root
//We dont have to create new object everytime to add new functionality
public class SimpleSandwich implements Sandwich {

    @Override
    public String make() {
        return "bread";
    }
}
