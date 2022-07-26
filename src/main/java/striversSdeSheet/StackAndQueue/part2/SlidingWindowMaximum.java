package main.java.striversSdeSheet.StackAndQueue.part2;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0;
        //To store index
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            //remove numbers out of range
            if (!queue.isEmpty() && queue.peek() == i - k) {
                queue.poll();
            }

            //remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            //Adding index
            queue.offer(i);
            //Resultant array will start be stored once i reaches k to meet the sliding window criteria
            //and find maximum within this sliding window
            if (i >= k - 1) {
                res[ri++] = nums[queue.peek()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = maxSlidingWindow(nums, 2);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
