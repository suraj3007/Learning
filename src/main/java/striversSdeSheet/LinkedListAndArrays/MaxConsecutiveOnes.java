package main.java.striversSdeSheet.LinkedListAndArrays;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;

        int maxi = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxi = Math.max(count, maxi);
                count = 0;
            }
        }

        return Math.max(count, maxi);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
