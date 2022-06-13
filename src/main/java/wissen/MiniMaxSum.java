package main.java.wissen;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        Collections.sort(arr);
        BigInteger minSum = BigInteger.ZERO, maxSum = BigInteger.ZERO;
        for(int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                minSum = minSum.add(BigInteger.valueOf(arr.get(i)));
            } else if (i == arr.size() - 1) {
                maxSum = maxSum.add(BigInteger.valueOf(arr.get(i)));
            } else {
                minSum = minSum.add(BigInteger.valueOf(arr.get(i)));
                maxSum = maxSum.add(BigInteger.valueOf(arr.get(i)));
            }
        }
        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3,4,5);
        miniMaxSum(arr);
    }
}
