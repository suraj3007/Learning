package main.java.leetcode;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSumOptimized(int[] nums, int target) {

        HashMap<Integer, Integer> numberIndicesMap = new HashMap<>();
        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (numberIndicesMap.containsKey(diff)) {
                return new int[]{numberIndicesMap.get(diff), i};
            }
            numberIndicesMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 15, 11, 7};
        int[] result = twoSumOptimized(nums, 9);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
