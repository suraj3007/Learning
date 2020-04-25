package main.java.com.pluralsight.bridge;

public abstract class Shape2 implements Color {

    protected Color color;

    public Shape2(Color color) {
        this.color = color;
    }

    @Override
    public abstract void applyColor(ShapeType shape);
}
