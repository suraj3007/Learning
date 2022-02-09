package main.java.interview;

import java.util.HashMap;
import java.util.Map;

public class MorganSolution {
    public static void main(String[] args) {
        A a = new A();
//        A a1 = new A();

        B b = new B();
//        B b1 = new B();

        C c = new C();
//        C c1 = new C();
    }
}

class A {
    static Map<String, Boolean> map = new HashMap<>();

     A() {
         String name = this.getClass().getSimpleName();
         if (!map.containsKey(name))
             map.put(name, true);
         else
             throw new RuntimeException("Already " + name + " instance created");
    }
}

class B extends A {
}

class C extends A {
}

class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 5, 8, 8, 10, 10};
        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[i] != arr[j])
                System.out.println(arr[i]);
            i++;
            j++;
        }
        System.out.println(arr[i]);
    }
}