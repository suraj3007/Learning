package main.java.striversSdeSheet.StackAndQueue.part1;

import java.util.Stack;

public class NextGreaterElement {

    /*public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        int[] nextGreaterElement = new int[nums1.length];

        for (int i = nums1.length - 1; i >= 0; i--) {

        }

        return new int[0];
    }*/

    public static int[] nextGreater(int[] arr, int n) {
        //Write Your code here
        Stack<Integer> stack = new Stack<>();
        int[] nextGreaterElement = new int[arr.length];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextGreaterElement[i] = -1;
            } else {
                nextGreaterElement[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return nextGreaterElement;
    }

    public static int[] nextGreaterInCyclicArray(int[] arr, int n) {
        //Write Your code here
        Stack<Integer> stack = new Stack<>();
        int[] nextGreaterElement = new int[n];

        for (int i = (2 * n) - 1; i >= 0; i--) {
            //arr[i % n] -> Reiterating the previous indexes
            while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
                stack.pop();
            }
            if (i < n) {  //While starting loop we have virtually copied the array again and started from back as 2n - 1
                          //But while storing next greater element (nextGreaterElement) for each index we have to find it for actual array.
                          //Hence, i < n.
                if (stack.isEmpty()) {
                    nextGreaterElement[i] = -1;
                } else {
                    nextGreaterElement[i] = stack.peek();
                }
            }
            //Basically copying the array again element by element index wise.
            stack.push(arr[i % n]);
        }
        return nextGreaterElement;
    }

    public static void main(String[] args) {

    }
}
