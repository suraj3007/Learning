package main.java.com.pluralsight.bridge;

public class Green implements Color {

    @Override
    public void applyColor(ShapeType shape) {
        System.out.println("Applying Green Color for " + shape);
    }
}
