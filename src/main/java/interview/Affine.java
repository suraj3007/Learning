package main.java.interview;

public class Affine {

    public static void main(String[] args) {
        int[] numbers = {41, 52, 94, 85, 62, 13, 9, 91};

        int max = numbers[0];
        int nextMax = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                if (i == numbers.length - 1) {
                    nextMax = max;
                }
                max = numbers[i];
            } else if (numbers[i] > nextMax) {
                nextMax = numbers[i];
            }
        }
        System.out.println(nextMax);
    }
}
