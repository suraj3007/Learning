package main.java.interview;


public class LargestNumberFormed {

    public static void main(String[] args) {
        int[] arr = {7, 8, 4, 0, 2, 9, 5, 4, 2};    //987544220
        int[] res = new int[arr.length];
        int max_index = -1;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                max_index = i;
            }
        }

    }
}
