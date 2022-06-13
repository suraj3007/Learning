package main.java.dataStructures.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfArray {

    private static void findPermutations(int[] arr, List<List<Integer>> ans, List<Integer> ds, boolean[] picked) {
        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!picked[i]) {
                //mapped as picked
                picked[i] = true;
                //pick
                ds.add(arr[i]);
                findPermutations(arr, ans, ds, picked);
                ds.remove(ds.size() - 1);
                //mapped as not picked once recursion over for this index
                picked[i] = false;
            }
        }
    }

    //Find all permutations for given array in any order.
    //Here, we are using map as extra space to identify if value is picked/considered
    private static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] picked = new boolean[arr.length];
        findPermutations(arr, ans, ds, picked);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("***** Permutation of array with extra space *****");
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> ans = permute(arr);
        System.out.println(ans);

        System.out.println("***** Permutation of array without extra space *****");
        int[] arr2 = new int[]{1, 2, 3};
        List<List<Integer>> ans2 = permuteOptimized(arr2);
        System.out.println(ans2);
    }

    //Find all permutations for given array in any order.
    //Here, we will not be using map as extra space to identify if value is picked/considered
    private static List<List<Integer>> permuteOptimized(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutationsOptimized(0, arr, ans);
        return ans;
    }

    private static void findPermutationsOptimized(int index, int[] arr, List<List<Integer>> ans) {
        if (index == arr.length) {
            List<Integer> ds = new ArrayList<>();
            for (int n : arr) {
                ds.add(n);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(i, index, arr);
            findPermutationsOptimized(index + 1, arr, ans);
            swap(i, index, arr);
        }
    }

    private static void swap (int i, int j, int[] num) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
