package main.java.dataStructures;

interface findFactorial {
    FactorialWrapper getFactorial(int n);
}

public class Revise implements findFactorial {

    public static void main(String[] args) {
        int n = 100;
        FactorialWrapper obj = new Revise().getFactorial(n);

        System.out.println("Factorial of " + n +" : ");
        int res_size = obj.getRes_size();
        int res[] = obj.getRes();
        for (int i = res_size - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
    }

    public FactorialWrapper getFactorial(int n) {
        int[] res = new int[500];
        res[0] = 1;
        int res_size = 1;

        for (int i = 2; i <= n; i++) {
            res_size = multiply(i, res, res_size);
        }

        return new FactorialWrapper(res, res_size);
    }

    private static int multiply(int n, int[] res, int res_size) {
        int carry = 0;

        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * n + carry;
            res[i] = prod % 10;
            carry = prod/10;
        }

        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry/10;
            res_size++;
        }
        return res_size;
    }
}

class FactorialWrapper {
    private int[] res;
    private int res_size;

    FactorialWrapper(int[] res, int res_size) {
        this.res = res;
        this.res_size = res_size;
    }

    public int[] getRes() {
        return res;
    }

    public int getRes_size() {
        return res_size;
    }
}

class ReviseFibonacci {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = fibo(n);
        System.out.print ("Fibonacci series are : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        n = 6;
        System.out.println("Value at " + n + "th position in fibonacci series : " + arr[n - 1]);
        System.out.println("Value at " + n + "th position in fibonacci series : " + fibonacciAtPosition(n));
    }

    private static int fibonacciAtPosition(int n) {
        int a = 0; int b = 1; int c = 0;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    private static int[] fibo(int n) {

        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr;
    }
}