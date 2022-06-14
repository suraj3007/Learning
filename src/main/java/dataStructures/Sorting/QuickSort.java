package main.java.dataStructures.Sorting;

public class QuickSort {

    public static void main(String[] args) {

        QuickSort obj = new QuickSort();
        int[] arr = {45, 32, 87, 56, 101, 79, 12};
        obj.sort(arr, 0, arr.length - 1);
        System.out.println("Array Sorted...");
        obj.print(arr);
    }

    private void print(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private void sort(int[] arr, int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[high] = temp;

        return i + 1;
    }
}
