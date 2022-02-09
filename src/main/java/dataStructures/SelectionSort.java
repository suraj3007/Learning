package main.java.dataStructures;


public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
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
        for (int i = 0; i < n - 1; i++) { // i < 6
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
