package main.java.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        arr = rotateLeft(4, arr);
        System.out.println(arr);
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        // 1 2 3 4 5 -> 5 1 2 3 4
        List<Integer> joined = new ArrayList<>();
        joined.addAll(arr.subList(d, arr.size()));
        joined.addAll(arr.subList(0, d));
        return joined;
    }


}
