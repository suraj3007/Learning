package main.java.learning1;

public class LargestAndSmallestNumber {

    public static void main(String[] args) {
        int arr[] = {41, 24, 67, 84, 45, 11, 47};

        int min = arr[0], max = arr[0];
        for (int n : arr) {

            if (n < min) {
                min = n;
            }

            if (n > max) {
                max = n;
            }
        }
        System.out.println("Minimum value : " + min + " & Maximum value : " + max);
    }
}


class KthSmallestNumber {

    public static void main(String[] args) {
        int arr[] = {41, 24, 67, 84, 41, 11, 47};
        int k = 5;
        int value;
        if (k <= arr.length) {
            value = findNumber(arr, k);
            System.out.println(value);
        } else {
            System.out.println("k is greater than array size..");
        }
    }

    private static Integer findNumber(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            if (k - 1 == i) {
                return arr[i];
            }
        }
        return null;
    }
}