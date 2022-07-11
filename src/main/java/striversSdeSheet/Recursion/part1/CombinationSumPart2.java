package main.java.striversSdeSheet.Recursion.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumPart2 {

    //To get the combination of sum in sorted order and combination should not be repetitive.
    //Also, you can use 1 value only once.
    private static List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombinations2(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombinations2(int index, int[] arr, int target, List<List<Integer>> ans,
                                          List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            //If values at i and i+1 are same then don't consider. As same number will get entered into ds & considered for sum.
            if (i != index && arr[i] == arr[i - 1]) {
                continue;
            }
            //If after reducing the target, next value is greater than all numbers after that will be greater
            //as array is sorted. So, break the loop for this recursion
            if (arr[i] > target) {
                break;
            }
            ds.add(arr[i]);
            //Here, incrementing the i as 1 value we have to consider once.
            findCombinations2(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("**** Combination sum 2 leetcode ****");
        int[] arr2 = new int[]{1, 1, 1, 2, 2};
        List<List<Integer>> ans2 = combinationSum2(arr2, 4);
        ans2.forEach(System.out::println);
    }
}
