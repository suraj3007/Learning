package main.java.striversSdeSheet.BinarySearch;

public class FindSingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == nums[mid ^ 1]) { //Cool trick get next index
                //If left half then find the break point.
                low = mid + 1;
            } else {
                //If right half, shrink high pointer to find left half.
                high = mid - 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {

    }

    public int singleNonDuplicate2(int[] nums) {
        int i = 0, j = 1;
        while(i < nums.length && j < nums.length) {
            if (nums[i] != nums[j]) {
                return nums[i];
            }
            i = i + 2;
            j = j + 2;
        }
        return nums[i];
    }
}
