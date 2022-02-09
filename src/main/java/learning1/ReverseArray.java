package main.java.learning1;

import java.util.ArrayList;
import java.util.List;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {34, 42, 12, 22, 67, 87, 69, 54, 77};
        List<Integer> list = new ArrayList<>();
        arr = reverseArray(arr);

        for (int n : arr) {
            list.add(n);
        }
        System.out.println(list);
    }

    private static int[] reverseArray(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }
}
