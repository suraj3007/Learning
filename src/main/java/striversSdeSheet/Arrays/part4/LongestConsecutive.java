package main.java.striversSdeSheet.Arrays.part4;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)  return 0;
        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums) {
            hashSet.add(n);
        }
        int longestStreak = 0;
        int currentNum, currentStreak = 0;
        for (int n : nums) {
            //Here, we are trying to find the  minimal value of the sequence so that we can start checking
            //from their upto complete sequence available.
            //If not available then do nothing and move to next iteration.
            if (!hashSet.contains(n - 1)) {
                currentNum = n;
                currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
