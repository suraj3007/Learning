package main.java.striversSdeSheet.Arrays.part1;

public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
//        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(maxProfit(nums));
    }
}
