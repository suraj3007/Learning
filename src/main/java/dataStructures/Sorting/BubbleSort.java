package main.java.dataStructures.Sorting;

public class BubbleSort {

    public static void main(String[] args) {

        BubbleSort obj = new BubbleSort();
        int[] arr = {45, 32, 87, 56, 101, 79, 12};
//        int[] arr = {12, 32, 45, 56, 79, 87, 101};

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
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }
}
