package main.java.leetcode;

public class PairOfSongs {

    public static int numPairsDivisibleBy60(int[] time) {

        int count = 0;
        for (int i = 0; i < time.length - 1; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numPairsDivisibleBy60Optimized(int[] time) {

        int ans = 0;
        int[] count = new int[60];

        for (int t : time) {
            t %= 60;
            ans += count[(60 - t) % 60];
            ++count[t];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] time = {30,20,150,100,40, 200};
        System.out.println(numPairsDivisibleBy60Optimized(time));
    }
}
