package main.java.com.pluralsight.decorator;

//Adding functionality to the Sandwich
public class DressingDecorator extends SandwichDecorator {

    public DressingDecorator(Sandwich customSandwich) {
        super(customSandwich);
    }

    @Override
    public String make() {
        //System.out.println("Dressing decorator -> " + customSandwich.make());;
        //Decorating the decorator itself
        return customSandwich.make() + addDressing();
    }

    private String addDressing() {
        return " + mustard";
    }
}
