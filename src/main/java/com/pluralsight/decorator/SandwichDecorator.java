package main.java.com.pluralsight.decorator;

//Base decorator
public abstract class SandwichDecorator implements Sandwich {

    Sandwich customSandwich;

    public SandwichDecorator(Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    }

    public String make() {
        return customSandwich.make();
    }
}
