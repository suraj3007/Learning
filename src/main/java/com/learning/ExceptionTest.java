package main.java.com.learning;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println("start");
        ArithmeticException e = new ArithmeticException();
        try {
            throw e;
        } catch (Exception e1) {
            //Exception e1 = new ArithmeticException();
            e = (ArithmeticException) e1;
            e1 = e;
        }
        System.out.println("End");
    }
}


class ExceptionTest1 {
    public static void main(String[] args) {
        doStuff();
        System.out.println("main");
    }

    private static void doStuff() {
        doMoreStuff();
        System.out.println(10 / 0);
        System.out.println("Hi");
    }

    private static void doMoreStuff() {
        System.out.println("Hello");
    }
}

class ExceptionTest2 {
    public static void main(String[] args) {

        try {
            PrintWriter pw = new PrintWriter("abc.txt");
            pw.write("hello");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(e);
            //System.out.println(e.getMessage());
        }
        try {

        } finally {

        }
    }
}

class ExceptionTest3 {
    public static void main(String[] args) throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Hello");
    }
}

class ExceptionTest4 {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }
}

class ExceptionTest5 {
    static {
        int x = 10/0;
    }
    public static void main(String[] args) {
        try{
            System.out.println("Hello");
        }
        catch (Exception e){

        }
//        catch (IOException e){ }      CE: java: exception java.io.IOException is never thrown in body of corresponding try statement
    }
}
