package main.java.interview;


import java.util.*;
import java.util.stream.Collectors;

public class LargestNumberFormed {

    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(7, 8, 4, 0, 2, 9, 5, 4, 2); //987544220
        List<Integer> numbers = Arrays.asList(10, 68, 97, 9, 21, 12); //99768211210
        Collections.sort(numbers,
                (a,b) -> (String.valueOf(b) + a).compareTo((String.valueOf(a) + b)));
        String ans = numbers.stream().map(Object::toString).collect(Collectors.joining(""));
        System.out.println(ans);
    }
}
