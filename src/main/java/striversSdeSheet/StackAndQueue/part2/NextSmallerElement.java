package main.java.striversSdeSheet.StackAndQueue.part2;
import java.util.*;

public class NextSmallerElement {

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> stack  = new Stack<>();
        Integer[] nextSmallerElement = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextSmallerElement[i] = -1;
            } else {
                nextSmallerElement[i] = stack.peek();
            }
            stack.push(arr.get(i));
        }
        return new ArrayList<>(List.of(nextSmallerElement));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(1);

        System.out.println(nextSmallerElement(arr, 3));
    }
}
