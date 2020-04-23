package main.java.com.pluralsight.adapter;

import java.util.Arrays;
import java.util.List;

public class AdapterDemo {

    public static void main(String[] args) {
        Integer[] arrayInts = new Integer[]{33, 45, 47, 48};
        List<Integer> listInts = Arrays.asList(arrayInts);      //This mtd act as a bridge b/w Array based & Collections based API

        System.out.println(arrayInts);
        System.out.println(listInts);
    }
}
