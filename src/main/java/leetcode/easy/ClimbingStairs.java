package main.java.leetcode.easy;

public class ClimbingStairs {

    //Hint: Fibonacci series
    //For 2 stairs = 2 ways, 3 stairs = 3 ways, 4 stairs  = 5 ways, 5 stairs = 8 ways and so on...
    public int climbStairs(int n) {
        //for logic refer line 6
        if (n <= 3) return n;
        return calculateWays(n);
    }

    public int calculateWays(int n) {
        //a = 2, b = 3 because first 2 numbers of this series
        int a = 2, b = 3, c = 0;
        for (int i = 4; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
    }
}
