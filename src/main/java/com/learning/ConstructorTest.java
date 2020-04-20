package main.java.com.learning;


import java.io.IOException;

/**
 * Use of instance block.
 */
public class ConstructorTest {

    static int count = 0;

    {
        count++;
    }

    ConstructorTest() {
    }

    ConstructorTest(int i) {
    }

    ConstructorTest(double d) {
    }

    public static void main(String[] args) {
        ConstructorTest test = new ConstructorTest();
        ConstructorTest t2 = new ConstructorTest(10);
        ConstructorTest t3 = new ConstructorTest(10.5);
        System.out.println("No of object gets created : " + count);
    }

}

class Test1 {
    Test1() throws IOException{

    }

}

class Test2 extends Test1{

    Test2() throws IOException{

    }

}