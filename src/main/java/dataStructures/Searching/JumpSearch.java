package main.java.dataStructures.Searching;

import java.util.Arrays;

public class JumpSearch {

//    private static int jumpSearch(int[] arr, int number) {
//
//        int block = (int) Math.floor(Math.sqrt(arr.length));
//        int val1 = arr[0];
//
//        for (int i = 1; i <= arr.length / block + 1; i++) {
//
//            int blockIndex = (block * i) - 1;
//            if (blockIndex > arr.length - 1) {
//                return linearSearch(arr, blockIndex, number);
//            }
//            int val2 = arr[blockIndex];
//            if (val2 == number)
//                return blockIndex;
//            if (number >= val1 && number <= val2) {
//                return linearSearch(arr, blockIndex, number);
//            }
//            val1 = val2;
//        }
//
//        return -1;
//    }
//
//    private static int linearSearch(int[] arr, int blockIndex, int number) {
//        for (int j = blockIndex - 3; j <= arr.length - 1; j++) {
//            int val = arr[j];
//            if (val == number)
//                return j;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 899};
//        int[] arr = {0, 2};
        int result = jumpSearch1(arr, 45);
        System.out.println((result < 0) ?
                "Element is not present in array" :
                "Element is present at index " +
                        result);
    }

    static int exponentialSearch(int arr[],
                                 int n, int x)
    {
        // If x is present at first location itself
        if (arr[0] == x)
            return 0;

        // Find range for binary search by
        // repeated doubling
        int i = 1;
        while (i < n && arr[i] <= x)
            i = i*2;

        // Call binary search for the found range.
        return Arrays.binarySearch(arr, i/2,
                Math.min(i, n), x);
    }

    public static int jumpSearch1(int[] arr, int x)
    {
        int n = arr.length;

        // Finding block size to be jumped
        int step = (int)Math.floor(Math.sqrt(n));

        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n)-1] < x)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x)
        {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (arr[prev] == x)
            return prev;

        return -1;
    }
}
