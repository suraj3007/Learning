package main.java.dataStructures.Recursion;

import java.util.ArrayList;
import java.util.stream.Collectors;

//take | not-take technique
public class FindSubsequences {

    private static void findSubsequences(int index, int[] arr, ArrayList<Integer> list) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }
        //take or pick the particular index into the subsequence
        list.add(arr[index]);
        findSubsequences(index + 1, arr, list);
        //to remove the recently inserted element
        list.remove(list.size() - 1);

        //not pick or not take condition, this element is not added to your subsequence
        findSubsequences(index + 1, arr, list);
    }

    private static void printSubsequenceWhoseSumIsK(int index, int[] arr, ArrayList<Integer> list, int k) {
        if (index == arr.length) {
            int sum = list.stream().collect(Collectors.summingInt(Integer::intValue));
            if (sum == k) {
                System.out.println(list);
            }
            return;
        }
        //take or pick the particular index into the subsequence
        list.add(arr[index]);

        printSubsequenceWhoseSumIsK(index + 1, arr, list, k);

        //to remove the recently inserted element
        list.remove(list.size() - 1);

        //not pick or not take condition, this element is not added to your subsequence
        printSubsequenceWhoseSumIsK(index + 1, arr, list, k);
    }

    private static boolean printOnlyOneSubsequenceWhoseSumIsK(int index, int[] arr, ArrayList<Integer> list, int k) {
        if (index == arr.length) {
            int sum = list.stream().collect(Collectors.summingInt(Integer::intValue));
            //If condition satisfied
            if (sum == k) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        //take or pick the particular index into the subsequence
        list.add(arr[index]);
        if(printOnlyOneSubsequenceWhoseSumIsK(index + 1, arr, list, k)) {
            return true;
        }

        //to remove the recently inserted element
        list.remove(list.size() - 1);

        //not pick or not take condition, this element is not added to your subsequence
        if(printOnlyOneSubsequenceWhoseSumIsK(index + 1, arr, list, k)) {
            return true;
        }
        return false;
    }

    private static int printCountOfSubsequencesWhoseSumIsK(int index, int[] arr, int k, int sum) {
        if (index == arr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }
        sum += arr[index];
        int left = printCountOfSubsequencesWhoseSumIsK(index + 1, arr, k, sum);

        sum -= arr[index];
        int right = printCountOfSubsequencesWhoseSumIsK(index + 1, arr, k, sum);

        return left + right;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[]{3, 1, 2};
        findSubsequences(0, arr, list);

        System.out.println("********** Subsequence whose sum is k ************");
        printSubsequenceWhoseSumIsK(0, arr, list, 3);

        System.out.println("********** Only 1 Subsequence whose sum is k ************");
        printOnlyOneSubsequenceWhoseSumIsK(0, arr, list, 3);

        System.out.println("********** Count of Subsequence whose sum is k ************");
        System.out.println("Count: " + printCountOfSubsequencesWhoseSumIsK(0, arr, 3, 0));;
    }
}
