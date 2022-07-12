package main.java.striversSdeSheet.Recursion.part2;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfStringOrArray {

    public void findPermute(int index, int[] nums, List<List<Integer>> ans)
    {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            findPermute(index + 1, nums, ans);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermute(0, nums, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
