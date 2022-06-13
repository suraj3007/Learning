package main.java.dataStructures.Recursion;

public class ReverseArray {

    private static void reverseArrayUsingTwoPointers(int l, int r, int[] arr) {
        if (l >= r) {
            return;
        }
        swap(l, r, arr);
        reverseArrayUsingTwoPointers(l + 1, r - 1, arr);
    }

    private static void swap(int l, int r, int[] arr) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private static void reverseArrayUsingOnePointer(int index, int[] arr) {
        if (index > arr.length / 2) {
            return;
        }
        //formula: n - i - 1;
        swap(index, arr.length - index - 1, arr);
        reverseArrayUsingOnePointer(index + 1, arr);
    }

    private static boolean checkPalindrome(int index, int[] arr) {

        if (index >= arr.length/2) {
            return true;
        }

        if (arr[index] != arr[arr.length - index - 1]) {
            return false;
        }

        return checkPalindrome(index + 1, arr);
    }

    public static void main(String[] args) {
        //Using 2 Pointer
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        System.out.println("Using 2 Pointer: -");
        reverseArrayUsingTwoPointers(0, arr1.length - 1, arr1);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        //Using 1 Pointer
        System.out.println("\nUsing 1 Pointer: -");
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        reverseArrayUsingOnePointer(0, arr2);
        for (int i : arr2) {
            System.out.print(i + " ");
        }

        int[] arr3 = new int[]{1, 2, 3, 3, 2, 1};
        System.out.println(checkPalindrome(0, arr3) ?
                "\nPalindrome" :
                "\nNot a Palindrome");
    }
}
