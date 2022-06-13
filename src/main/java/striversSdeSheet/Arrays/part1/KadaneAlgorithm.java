package main.java.striversSdeSheet.Arrays.part1;

//Kadane's algorithm: - Carry the sum value until it returns positive value otherwise set it to zero.
public class KadaneAlgorithm {

    public static int maxSubArray(int[] nums) {
        //initialize first value as max.
        int sum = 0,  maxSum = nums[0];
//        int startIndex = -1, endIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //If asked to provide the subset start and end index
//            if (startIndex == -1) startIndex = i;
            if (maxSum < sum) {
                maxSum = sum;
//                endIndex = i;
            }
            if (sum < 0) {
                sum = 0;
//                startIndex = -1;
            }
        }
//        System.out.println("Start index: " + startIndex + " End Index: " + endIndex);
        //To avoid scenarios, if all values are -ve in test cases
        return maxSum < 0 ? 0 : maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { -2,1,-3,4,-1,2,1,-5,4 };
        System.out.println(maxSubArray(nums));
    }
}
