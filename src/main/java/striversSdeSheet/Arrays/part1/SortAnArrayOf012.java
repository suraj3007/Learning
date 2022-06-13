package main.java.striversSdeSheet.Arrays.part1;

/**
 * Dutch National flag algorithm is used to sort this in O(N) TC.
 * [0 ... low -1] -> 0 (Left side of low pointer will contains 0's)
 * [high + 1 ... n] -> 2 (Right side of high pointer will contains 2's)
 */
public class SortAnArrayOf012 {

    /**
     * Maintain 3 pointers : low, mid, high -> low = mid = 0; high = size - 1
     * If mid finds value as 0 -> Swap low with mid & increment both low & mid pointer
     * If mid finds value as 1 -> Just increment mid pointer
     * If mid finds value as 2 -> Swap high with mid & decrement high pointer
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0 : {
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                }
                case 1 : {
                    mid++;
                    break;
                }
                case 2 : {
                    swap(nums, mid, high);
                    high--;
                    break;
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
