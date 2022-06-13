package main.java.dataStructures.Recursion;

public class NthFibonacciNumber {

    //multiple recursion calls
    private static int nthFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        //Here, we are calling recursive function twice so, time complexity would be O(2^n)
        //Because every recursive execution will invoke these calls twice.
        int last = nthFibonacci(n - 1);
        int sLast = nthFibonacci(n - 2);
        return last + sLast;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(n + "th fibonacci number: " +nthFibonacci(n));
    }
}
