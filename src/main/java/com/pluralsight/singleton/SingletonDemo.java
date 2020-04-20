package main.java.com.pluralsight.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        Runtime firstInstance = Runtime.getRuntime();
        firstInstance.gc();
        System.out.println(firstInstance);

        Runtime anotherInstance = Runtime.getRuntime();
        System.out.println(anotherInstance);

        if(firstInstance == anotherInstance){
            System.out.println("They are the same instance");
        }
    }
}
