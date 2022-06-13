package main.java.striversSdeSheet.Arrays.part4;

import java.util.HashMap;
import java.util.Map;

/**
 * Intuition: Let say we have an array of size 10 and summation required is 15.
 * If by 4th index we got our summation = 15, it means from 5th to 9th index summation will be zero.
 * Same logic we are going to apply here. It will be divided into 2 halves.
 * 1. From start, keep adding values and check if sum == 0, otherwise keep storing sum and index into map.
 * If we get sum == 0 from the beginning then calculate maxi by i + 1. That will be your first sequence.
 * 2. Then after every sum, check if it exists in map.
 * If yes, it means that we received that sum earlier at particular index.
 * This indicates that after that index till current index, summation is zero as per our intuition above.
 * So, calculate the sequence length by current index - index of that sum and compare it with maxi.
 * Don't store this sum and index pair in map, bcoz key already exist and also we want largest sequence.
 * Otherwise, index will get updated to recent one and we wont be able to get largest sequence.
 */
public class LargestSubArrayWithZeroSum {

    static int maxLen(int arr[], int n) {
        // Your code here
        if (arr.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxi = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            //Step 1
            if (sum == 0) {
                maxi = i + 1;
                //Step 2
            } else if (map.containsKey(sum)) {
                maxi = Math.max(maxi, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(arr, arr.length));
    }
}
