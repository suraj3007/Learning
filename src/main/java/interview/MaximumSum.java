package main.java.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class MaximumSum {

    private static int[] maxSum(int[] arr) {
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length - 1; i++) {
            map.put((arr[i] + arr[i + 1]), i + " " + (i + 1));
        }
        String[] split = map.firstEntry().getValue().split(" ");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }

    public static void main(String[] args) {
        int[] arr = {100, 400, 600, 200, 500};
        Arrays.stream(maxSum(arr)).forEach(s -> {
            System.out.print(s + " ");
        });
    }
}
