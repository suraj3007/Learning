package main.java.com.pluralsight.decorator;

//Adding functionality to the Sandwich
public class PaneerDecorator extends SandwichDecorator {

    public PaneerDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    public String make() {
        //System.out.println("Paneer decorator -> " + customSandwich.make());
        //Decorating the decorator itself
        return customSandwich.make() + addPaneer();
    }

    private String addPaneer() {
        return " + Paneer";
    }
}
