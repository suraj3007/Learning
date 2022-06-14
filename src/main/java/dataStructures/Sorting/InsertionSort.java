package main.java.dataStructures.Sorting;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        int[] arr = {45, 32, 87, 56, 101, 79, 12};
        obj.sort(arr);
        System.out.println("Array Sorted...");
        obj.print(arr);
    }

    private void print(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1 ; i < n; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
