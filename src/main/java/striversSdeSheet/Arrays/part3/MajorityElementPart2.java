package main.java.striversSdeSheet.Arrays.part3;

import java.util.ArrayList;
import java.util.List;

/**
 * This time we have to find all element which occurs more than n/3 times.
 * First thing to click: - more than n/3 times means there will be only 2 elements or lesser than that
 * Boyer Moore voting algorithm.
 * Just like Moore voting algorithm, instead of 1 here we will track for 2 elements.
 */

public class MajorityElementPart2 {

    public static List<Integer> majorityElement(int[] nums) {
        int number1 = -1, number2 = -1, count1 = 0, count2 = 0;
        for (int n : nums) {
            if (number1 == n) {
                count1 += 1;
            } else if (number2 == n) {
                count2 += 1;
            } else if (count1 == 0) {
                number1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        //Check if both the number are more than n/3 times
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 =0;
        for (int n : nums) {
            if (number1 == n) {
                count1++;
            } else if (number2 == n) {
                count2++;
            }
        }
        if (count1 > nums.length/3) {
            result.add(number1);
        }
        if (count2 > nums.length/3) {
            result.add(number2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3};
        System.out.println(majorityElement(nums));
    }
}
