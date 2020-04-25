package main.java.com.pluralsight.bridge;

public class Red implements Color {

    @Override
    public void applyColor(ShapeType shape) {
        System.out.println("Applying Red color for " +shape);
    }
}
