package main.java.com.pluralsight.bridge;

public class Circle2 extends Shape2 {

    public Circle2(Color color) {
        super(color);
    }

    @Override
    public void applyColor(ShapeType shape) {
        color.applyColor(shape);
    }
}
