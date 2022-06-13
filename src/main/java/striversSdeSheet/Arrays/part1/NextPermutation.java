package main.java.striversSdeSheet.Arrays.part1;

public class NextPermutation {

    /**
     * Step 1: - Get index i from back where a[i] < a[i + 1]
     * Step 2: - Get index j from back where a[j] > a[i]
     * Step 3: - Swap index i and j
     * Step 4: - Reverse string from i + 1 to length - 1
     * @param nums
     */
    // 1 3 5 4 2
    public static void nextPermutation(int[] nums) {
        //If array contains 0 or 1 value then return as it is.
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        //Step 1 implemented
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //Step 2 implemented
            while (nums[j] <= nums[i]) {
                j--;
            }
            //Step 3 implemented
            swap(nums, i, j);
        }
        //Step 4 implemented
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
