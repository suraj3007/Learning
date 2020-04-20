package main.java.com.learning;

public class SingletonTest {
    private static SingletonTest test = null;

    private SingletonTest() {
    }

    public static SingletonTest getSingletonTest() {
        if (test == null){
            test = new SingletonTest();
        }
        return test;
    }
}

class Test3 {

    public static void main(String[] args) {

        SingletonTest test1 = SingletonTest.getSingletonTest();
        SingletonTest test2 = SingletonTest.getSingletonTest();
        System.out.println(test1.equals(test2));
        System.out.println(test1);
        System.out.println(test1 == test2);
    }

}