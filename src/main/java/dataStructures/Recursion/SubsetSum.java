package main.java.dataStructures.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

    private static void findSubsetSum(int index, int sum, List<Integer> arr, ArrayList<Integer> subsetSums) {
        if (index == arr.size()) {
            subsetSums.add(sum);
            return;
        }
        //pick : do sum
        findSubsetSum(index + 1, sum + arr.get(index), arr, subsetSums);
        //not pick : don't do sum
        findSubsetSum(index + 1, sum, arr, subsetSums);
    }

    //find all the combination of sum from given distinct array values in increasing order.
    //Here, array wont contain duplicate values
    private static ArrayList<Integer> subsetSums(List<Integer> arr) {
        ArrayList<Integer> subsetSums = new ArrayList<>();
        findSubsetSum(0, 0, arr, subsetSums);
        Collections.sort(subsetSums);
        return subsetSums;
    }

    public static void main(String[] args) {
        System.out.println("***** Subset Sum 1 *****");
        List<Integer> arr = Arrays.asList(3, 1, 2);
        ArrayList<Integer> ans = subsetSums(arr);
        System.out.println(ans);

        System.out.println("***** Subset Sum 2 *****");

        int[] arr2 = new int[]{2, 1, 2, 3, 2, 3};
        List<List<Integer>> ans2 = subsetSums2(arr2);
        System.out.println(ans2);
    }

    //find all the combination of sum from given array in increasing order. Array can contain duplicates.
    //So, duplicates of combination is not allowed.
    private static List<List<Integer>> subsetSums2(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);   //To get the duplicates side by side
        findSubsetSum2(0, arr, ans, new ArrayList<>());
        return ans;
    }

    private static void findSubsetSum2(int index, int[] arr, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) {
                continue;
            }
            ds.add(arr[i]);
            //For every recursion call, list size will increase by 1.
            findSubsetSum2(i + 1, arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
