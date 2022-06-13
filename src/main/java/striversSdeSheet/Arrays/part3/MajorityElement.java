package main.java.striversSdeSheet.Arrays.part3;

import java.util.*;

/**
 * Here, we have to find an element which occurs more than n/2 times.
 * First thing to click: - more than n/2 times means there will be only 1 element
 * Moore voting algorithm.
 * In problem statement it is mentioned that majority element will be more than n/2 times
 * It means its count will be greater than combined count of all elements.
 * So at the end, count of majority element will cancel out each other and still it wont be equal to 0.
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int count = 0, majorityElement = 0;
        for(int i : nums){
            if (count == 0) {
                //In first iteration, defining first element as majorityElement
                //By end, majorityElement will be whose count will greater than combined count of all elements.
                majorityElement = i;
            }
            if (majorityElement == i) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        return majorityElement;
    }

    //Coding ninja
    public static int majorityElement2(int[] nums, int n) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            if (map.get(i) > n/2) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {20, 20, 20, 4, 5, 20, 1, 20, 4, 20};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums, nums.length));
    }
}
