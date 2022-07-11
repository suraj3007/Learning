package main.java.striversSdeSheet.Recursion.part1;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private static boolean checkPalindrome(String s, int start, int end) {
        while(start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private static void performPartition(int index, String s, List<List<String>> res, List<String> ds) {
        if (index == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (checkPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                performPartition(i + 1, s, res, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        performPartition(0, s, res, ds);
        return res;
    }

    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> res = partition(str);
        System.out.println(res);
    }
}
