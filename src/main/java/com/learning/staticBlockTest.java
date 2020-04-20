package main.java.com.learning;

/**
 * Use case 1: Without writing main method can we print some statement to the console
 * <p>
 * Valid upto 1.6 version
 */

public class staticBlockTest {

    static {
        System.out.println("Hello.. I can print");
        System.exit(0);         //This is required to stop JVM. Otherwise we will RE saying NoSuchMethodError:main
    }

}

/**
 * USeCase 2 : Without writing main method & static block can we print some statement to the console. Valid upto 1.6 version
 * Approach 1
 */

class staticBlockTest2 {

    static int x = m1();

    private static int m1() {
        System.out.println("In static method");
        System.exit(0);
        return 10;
    }

}

/**
 * Approach 2
 */

class staticBlockTest3 {

    static staticBlockTest3 test = new staticBlockTest3();

    {
        System.out.println("Using Instance block");     //By using instance block
        System.exit(0);
    }
}

/**
 * Approach 3
 */

class staticBlockTest4 {

    static staticBlockTest4 test = new staticBlockTest4();

    staticBlockTest4() {                                  //By using constructor block
        System.out.println("Using constructor block");
        System.exit(0);
    }
}
