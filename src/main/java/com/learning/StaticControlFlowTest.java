package main.java.com.learning;

public class StaticControlFlowTest {
    static int i = 10;


    static {
        m1();
        System.out.println("First static block");
    }

    public static void main(String[] args) {
        m1();
        System.out.println("Main method");
    }

    private static void m1() {
        System.out.println(j);
    }

    static {
        System.out.println("Second static block");
        System.out.println(i);
    }

    static int j = 20;
}

class staticTest {

    static {
        m1();                           //Indirect read. we are perfoming read operation by calling method
        //System.out.println(x);        //Illegal forward reference -> Direct read
    }

    private static void m1() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        System.out.println("main method");
    }

    static int x = 10;
}

class staticTest2 {
    static int x =5;
    static {
        System.out.println(x);
    }

    public static void main(String[] args) {
        System.out.println("Main method");
    }
}