package main.java.striversSdeSheet.Recursion.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsPart2 {

    //find all the combination of sum from given array in increasing order. Array can contain duplicates.
    //So, duplicates of combination is not allowed.
    private static List<List<Integer>> subsetWithDuplicates(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);   //To get the duplicates side by side
        findSubsets(0, arr, ans, new ArrayList<>());
        return ans;
    }

    private static void findSubsets(int index, int[] arr, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) {
                continue;
            }
            ds.add(arr[i]);
            //For every recursion call, list size will increase by 1.
            findSubsets(i + 1, arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("***** Subset Sum 2 *****");
        int[] arr2 = new int[]{2, 1, 2, 3, 2, 3};
        List<List<Integer>> ans2 = subsetWithDuplicates(arr2);
        System.out.println(ans2);
    }
}
