package main.java.dataStructures.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

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

    //To get all the combinations of sum in any order.
    //Also, you can use 1 value any number of times from array..
    private static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("**** Combination sum 1 leetcode ****");
        int[] arr1 = new int[]{2, 3, 6, 7};
        List<List<Integer>> ans = combinationSum(arr1, 7);
        ans.forEach(System.out::println);

        System.out.println("**** Combination sum 2 leetcode ****");
        int[] arr2 = new int[]{1, 1, 1, 2, 2};
        List<List<Integer>> ans2 = combinationSum2(arr2, 4);
        ans2.forEach(System.out::println);
    }

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
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            //If after reducing the target, next value is greater then all numbers after that will be greater
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
}
