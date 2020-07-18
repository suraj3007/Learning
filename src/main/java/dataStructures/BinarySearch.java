package main.java.dataStructures;

import java.util.Arrays;

public class BinarySearch {

    /**
     * Recursive approach
     *
     * @param arr
     * @param low
     * @param high
     * @param number
     * @return
     */
    private static int binarySearch1(int[] arr, int low, int high, int number) {
        int median = (high + low) / 2;

        if (high >= low) {
            if (arr[median] == number)
                return median;

            if (number > arr[median])
                return binarySearch1(arr, median + 1, high, number);

            return binarySearch1(arr, low, median - 1, number);
        }

        return -1;
    }

    /**
     * Iterative approach
     *
     * @param arr
     * @param x
     * @return
     */
    int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int median = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[median] == x)
                return median;

            // If x greater, ignore left half
            if (arr[median] < x)
                low = median + 1;

                // If x is smaller, ignore right half
            else
                high = median - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 12, 2, 38, 16, 23, 56, 91, 72};
        Arrays.sort(arr);
        int result = binarySearch1(arr, 0, arr.length - 1, 91);
        System.out.println((result < 0) ?
                "Element is not present in array" :
                "Element is present at index " +
                        result);
    }
}
