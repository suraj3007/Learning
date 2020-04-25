package main.java.com.pluralsight.bridge;

public class Square2 extends Shape2 {

    public Square2(Color color) {
        super(color);
    }

    @Override
    public void applyColor(ShapeType shape) {
        color.applyColor(shape);

    }
}
