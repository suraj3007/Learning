package main.java.dataStructures;

public class Fibonacci {

    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
    public static void main(String[] args) {
        int n = 9;
        System.out.println("Value at " + n + "th position in fibonacci series : " + fibonacciSeries(n));
        fibonacciSeriess(n);
    }

    private static int fibonacciSeries(int n) {
        int a = 0, b = 1, c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static void fibonacciSeriess(int n) {
        int[] arr = new int[n + 2];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println("Fibonacci series upto " + n + "th position : ");
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
