package main.java.com.pluralsight.flyweight;

//Instances of item will be flyweight
public class Item {

    private final String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
