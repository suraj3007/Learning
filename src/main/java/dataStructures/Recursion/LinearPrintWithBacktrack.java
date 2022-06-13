package main.java.dataStructures.Recursion;

public class LinearPrintWithBacktrack {

    private static void linearPrintOneToNUsingBacktrack(int n) {
        if (n == 0) {
            return;
        }
        linearPrintOneToNUsingBacktrack(n-1);
        System.out.print(n + " ");
    }

    private static void linearPrintNToOneUsingBacktrack(int i, int n) {
        if (i > n) {
            return;
        }
        linearPrintNToOneUsingBacktrack(i+1, n);
        System.out.print(i + " ");
    }

    public static void main(String[] args) {
        linearPrintOneToNUsingBacktrack(5);
        System.out.println("\n******* Reverse *******");
        linearPrintNToOneUsingBacktrack(1, 5);
    }
}
