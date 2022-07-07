package main.java.striversSdeSheet.GreedyAlgorithm;

public class FindMinimumNoOfCoins {

    public static int minimumCoins(int V) {
        if (V <= 0) return 0;
        int[] deno = {1, 2, 5, 10, 20, 100, 200, 500, 1000};
        int minimumCoins = 0;
        for (int i = deno.length - 1; i >= 0 && V > 0; i--) {
            while (V >= deno[i]) {
                V -= deno[i];
                minimumCoins++;
            }
        }
        return minimumCoins;
    }

    public static void main(String[] args) {
        System.out.println(minimumCoins(49));
    }
}
