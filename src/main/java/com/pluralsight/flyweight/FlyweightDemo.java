package main.java.com.pluralsight.flyweight;

/**
 * Flyweight Pattern : More efficient use of memory
 * We can use this pattern when we have to deal with large no. of similar objects
 */
public class FlyweightDemo {

    public static void main(String[] args) {

        Integer firstInt = Integer.valueOf(5);      //Check if this object is present. If not then create new object and cache the object.
        Integer secondInt =  Integer.valueOf(5);    //Now it will return the same object from cache as created in previous statement.
        Integer thirdInt =  Integer.valueOf(10);    //New object created.
        Integer fourthInt = Integer.valueOf("5");   //Will return the same object

        System.out.println(System.identityHashCode(firstInt));
        System.out.println(System.identityHashCode(secondInt));
        System.out.println(System.identityHashCode(thirdInt));
        System.out.println(System.identityHashCode(fourthInt));
    }
}
