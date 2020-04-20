package main.java.com.pluralsight.singleton;

import java.lang.reflect.Constructor;

public class TestSingleton {

    public static void main(String[] args) {

        DbSingleton instance = DbSingleton.getInstance();
        System.out.println(instance);

        DbSingleton anotherInstance = DbSingleton.getInstance();
        System.out.println(anotherInstance);

        if(instance == anotherInstance){
            System.out.println("Both are same instance");
        }
    }
}


class BreakSingleton {          //using reflections

    public static void main(String[] args) throws Exception {

        DbSingleton instance = DbSingleton.getInstance();

        Class cls = instance.getClass();
        //System.out.println(cls.getName());

        Constructor[] constructor = cls.getDeclaredConstructors();
        //System.out.println(constructor[0].getName());

        constructor[0].setAccessible(true);

        Object first = constructor[0].newInstance();
        Object second = constructor[0].newInstance();

        System.out.println(first);
        System.out.println(second);

        if (first == second) {
            System.out.println("Both instance are same");
        }else {
            System.out.println("Instance are not same");
        }


    }
}


class BreakSingleton2 implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        DbSingleton actual = DbSingleton.getInstance();
        Object cloned = actual.clone();

        System.out.println(actual);
        System.out.println(cloned);

        if (actual == cloned) {
            System.out.println("Both instance are same");
        }else {
            System.out.println("Instance are not same");
        }

    }
}
