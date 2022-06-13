package main.java.dataStructures.Recursion;

public class LinearPrintWithoutBacktrack {

    private static void printOneToN(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.print(i + " ");
        printOneToN(i + 1, n);
    }

    private static void printNToOne(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printNToOne(n - 1);
    }

    public static void main(String[] args) {
        printOneToN(1, 5);
        System.out.println("\n******* Reverse *******");
        printNToOne(5);
    }
}
