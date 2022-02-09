package main.java.learning;

public class SwapNumber {

    public static void main(String[] args) {
        int a = 10, b = 20;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping : a = " +a +" and b = " +b);
    }
}
