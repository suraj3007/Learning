package main.java.striversSdeSheet.LinkedListAndArrays;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
        // Write your code here.
        if (arr.size() == 0) return 0;
        int i = 0;
        for (int j = 1; j < arr.size(); j++) {
            if (arr.get(i) != arr.get(j)) {
                arr.add(++i, arr.get(j));
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
