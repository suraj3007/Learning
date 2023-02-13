package main.java.interview;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        int i = 0;
        for (int j = 0; j < 100; j++) {
            i = i++;
        }
        System.out.println(i);

        System.out.println("-------------------------------------------------------");

        String s = " ";
        s.trim();
        System.out.println(s.isEmpty() + ".." + s.equals(""));

        System.out.println("-------------------------------------------------------");

        List<String> list = new ArrayList<>();
        list.add("Suraj");
        list.add("Abhi");
        list.add("Milan");
        list.add("Divya");

        System.out.println(list);

//        for(String name : list){
//            list.remove(name);
//        }
//
//        System.out.println(list);

        System.out.println("-------------------------------------------------------");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum : " + sum);

        int sum2 = numbers.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum : " + sum2);

        int sum3 = numbers.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .reduce(0, (x, y) -> x + y);

        System.out.println("Sum : " + sum3);

        int sum4 = numbers.stream()
                .filter(n -> n % 2 == 1)
                .mapToInt(n -> n * n)
                .sum();

        System.out.println("Sum : " + sum4);
    }


}
