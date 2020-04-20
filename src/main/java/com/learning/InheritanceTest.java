package main.java.com.learning;


public class InheritanceTest {

    void m1() {
        System.out.println("Parent class");
    }

    public static void main(String[] args) {
        InheritanceTest test = new InheritanceTest();
        test.m1();
    }
}

class Child extends InheritanceTest {

    void m1 () {
        System.out.println("Child class");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.m1();

        InheritanceTest test = new InheritanceTest();
        test.m1();

        InheritanceTest t = new Child();
        t.m1();

    }
}

class Test {

    public static void main(String[] args) {
//        Child.main(new String[1]);
//
//        InheritanceTest.main(new String[]{});

        InheritanceTest t = new Child();        //Overloading main method. Ref will be used to print output
        t.main(new String[1]);

    }
}
