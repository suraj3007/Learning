package main.java.striversSdeSheet.Recursion.part1;

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
    }
}
