package main.java.striversSdeSheet.StackAndQueue.part2;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumOfMinimumOfEveryWindowSize {

    private static int maxOfMinSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        //To store index
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            //remove numbers out of range
            if (!queue.isEmpty() && queue.peek() == i - k) {
                queue.poll();
            }

            //remove larger numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] >= nums[i]) {
                queue.pollLast();
            }

            //Adding index
            queue.offer(i);
            //Resultant array will start be stored once i reaches k to meet the sliding window criteria
            //and find maximum within this sliding window
            if (i >= k - 1) {
                max = Math.max(max, nums[queue.peek()]);
            }
        }
        return max;
    }

    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        if (a == null || a.length == 0) return new int[]{-1};
        int[] maxOfMinimums = new int[n];

        for (int i = 1; i <= n; i++) {
            maxOfMinimums[i - 1] = maxOfMinSlidingWindow(a, i);
        }

        return maxOfMinimums;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,4,2,4};
        int[] res = maxMinWindow(nums, 5);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
