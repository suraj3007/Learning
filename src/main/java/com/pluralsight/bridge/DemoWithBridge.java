package main.java.com.pluralsight.bridge;

/**
 * Problem: Previously we created Square -> GreenSquare, RedSquare, BlackSqaure and so on.
 * For circle -> GreenCircle, RedCircle, BlackCircle and so on.
 * It means for different shapes and for that shape we created various color.
 * Solution : - Just create shape and Color. Nd for all shape pass color as an argument. That color can work with all different shape we want.
 */
public class DemoWithBridge {

    public static void main(String[] args) {
        Color red = new Red();                  //Here, we create Red color. It can be applied for all shape we want
        Shape2 square1 = new Square2(red);
        Shape2 circle1 = new Circle2(red);

        square1.applyColor(ShapeType.SQUARE);
        circle1.applyColor(ShapeType.CIRCLE);

        Color green = new Green();              //Green color on all shape
        Shape2 circle2 = new Circle2(green);
        Shape2 square2 = new Square2(green);

        circle2.applyColor(ShapeType.CIRCLE);
        square2.applyColor(ShapeType.SQUARE);

        /**
         * Now if we want to create new shape say Rectangle with all different color i.e red and green.
         * We just have to create Rectangle. Not Rectangle -> RedRectangle, GreenRectangle and so on..
         */

        Shape2 rectangle1 = new Rectangle(red);     //red color object reused
        Shape2 rectangle2 = new Rectangle(green);   //green color object reused

        rectangle1.applyColor(ShapeType.RECTANGLE);
        rectangle2.applyColor(ShapeType.RECTANGLE);
    }
}
