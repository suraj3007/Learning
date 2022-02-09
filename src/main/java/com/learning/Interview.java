package main.java.com.learning;

import java.util.ArrayList;
import java.util.List;

public class Interview {
}



class ShiftNumbers {
    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 4, 0, 0, 2, 3, 0, 9, 0};
        shiftZeros(arr);
    }

    private static void shiftZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i : arr){
            if (i != 0) {
                list.add(i);
            } else {
                count ++;
            }
        }

        if (count > 0) {
            for(int j = 0; j < count; j++) {
                list.add(0);
            }
        }

        System.out.println(list);
    }
}


class Parent {
    public void m1() {
        System.out.println("Parent class");
    }
}

class Child1 extends Parent {
    public void m1() {
        System.out.println("Child class");
    }

    void m1(int i) {
        System.out.println("Overloaded method");
    }
}

class TestOverriding {
    public static void main(String[] args) {
        Parent p = new Child1();
        p.m1();

        new Child1().m1(4);
    }
}

class overldmain
{
    public static void main(String[] args)
    {
        System.out.println("main(String[] args)");
    }

    public static void main(String args1)
    {
        System.out.println("main(String arg1)");
    }

    public static void main(String arg1, String arg2)
    {
        System.out.println("main(String arg1, String arg2)");
    }
}