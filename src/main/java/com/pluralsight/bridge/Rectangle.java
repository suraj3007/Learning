package main.java.com.pluralsight.bridge;

public class Rectangle extends Shape2 {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor(ShapeType shape) {
        color.applyColor(shape);
    }
}
