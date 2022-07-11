package main.java.striversSdeSheet.Recursion.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    //To get all the combinations of sum in any order.
    //Also, you can use 1 value any number of times from array..
    private static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans,
                                         List<Integer> ds) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //pick
        if (arr[index] <= target) {
            ds.add(arr[index]);
            //Remain at same index if it is asked in question that you can take value for any no. of times
            //as part of combination
            //Also, decrement the target with index.
            findCombinations(index, arr, target - arr[index], ans, ds);
            //make sure to remove the last element from list once recursion completes.
            ds.remove(ds.size() - 1);
        }

        //not pick. move to next index. Don't decrease the target.
        findCombinations(index + 1, arr, target, ans, ds);
    }

    public static void main(String[] args) {
        System.out.println("**** Combination sum 1 leetcode ****");
        int[] arr1 = new int[]{2, 3, 6, 7};
        List<List<Integer>> ans = combinationSum(arr1, 7);
        ans.forEach(System.out::println);
    }
}
