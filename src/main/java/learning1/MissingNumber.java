package main.java.learning1;


public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int miss = findMissingNumber(arr, 10);
        System.out.println(miss);

    }

    private static int findMissingNumber(int[] arr, int n) {
        int total;
        total = (n * (n + 1)) / 2;

        for (int i = 0; i < arr.length; i++) {
            total -= arr[i];
        }
        return total;
    }
}
