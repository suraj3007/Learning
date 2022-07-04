package main.java.striversSdeSheet.Arrays.part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = target - nums[j] - nums[i];
                int low = j + 1, high = n - 1;

                while (low < high) {
                    if (diff < nums[low] + nums[high]) {
                        high--;
                    } else if (diff > nums[low] + nums[high]) {
                        low++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        res.add(list);

                        //Skip duplicate numbers
                        while (low < high && nums[low] == list.get(2)) low++;

                        //Skip duplicate numbers
                        while (low < high && nums[high] == list.get(3)) high--;
                    }
                }
                //Skip duplicate numbers
                while (j + 1 < n && nums[j] == nums[j + 1]) ++j;
            }
            //Skip duplicate numbers
            while (i + 1 < n && nums[i] == nums[i + 1]) ++i;
        }

        return res;
    }

    //Coding ninjas
    public static String fourSum(int[] arr, int target, int n) {
        // Write your code here.
        Arrays.sort(arr);
        if (arr.length == 0 || arr == null) {
            return "No";
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = target - arr[j] - arr[i];
                int low = j + 1, high = n - 1;

                while (low < high) {
                    if (diff < arr[low] + arr[high]) {
                        high--;
                    } else if (diff > arr[low] + arr[high]) {
                        low++;
                    } else {
                        return "Yes";
                    }
                }
                //Skip duplicate numbers
                while (j + 1 < n && arr[j] == arr[j + 1]) ++j;
            }
            //Skip duplicate numbers
            while (i + 1 < n && arr[i] == arr[i + 1]) ++i;
        }

        return "No";
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0));
    }
}
