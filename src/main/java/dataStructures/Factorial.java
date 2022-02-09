package main.java.dataStructures;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {

        int n = 20;
        System.out.println("Factorial of " + n + " : " +findFactorial(n));
    }

    private static long findFactorial(int n) {
        long product = 1;
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        return product;
    }
}


class FactorialLargeNumber {

    public static void main(String[] args) {

        int n = 500;
        System.out.println("Factorial of " + n + " : " +findFactorial(n));
    }

    private static BigInteger findFactorial(int n) {
        BigInteger product = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        return product;
    }
}