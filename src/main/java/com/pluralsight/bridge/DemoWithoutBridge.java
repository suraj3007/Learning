package main.java.com.pluralsight.bridge;

public class DemoWithoutBridge {
    public static void main(String[] args) {
        Square square = new RedSquare();
        square.applyColor();

        Circle circle = new GreenCircle();
        circle.applyColor();

        //Now suppose if we want Black circle or square then we have to again create class and implement applyColor.
        //Suppose if we want new Shape say, Rectangle. Then, we have to extend shape and then create different colors for rectangle as well.
        //This will keep on increasing gradually.

        //Created black square & circle
        Square blackSquare = new BlackSquare();
        blackSquare.applyColor();

        Circle blackCircle = new BlackCircle();
        blackCircle.applyColor();
    }
}
