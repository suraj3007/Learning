package main.java.striversSdeSheet.BinarySearch;

public class SearchInRotatedSortedArray {

    //Time complexity: - O(log n) -> BinarySearch
    public static int searchOptimized(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (high + low)/2;
            if (nums[mid] == target) {
                return mid;
            } 
            //Left side is sorted
            else if (nums[low] <= nums[mid]) {
                //figure out if element lies on left half or not
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //Right half is sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    //Time complexity: - O(n)
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchOptimized(nums, 3));
    }
}
