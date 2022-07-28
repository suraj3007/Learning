package main.java.striversSdeSheet.BinaryTrees.part3;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class MaximumPathSum {

    private int findMaxSum(TreeNode root, int[] maxi) {
        if (root == null) {
            return 0;
        }

        int leftPathSum = Math.max(0, findMaxSum(root.left, maxi));
        int rightPathSum = Math.max(0, findMaxSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], root.val + leftPathSum + rightPathSum);

        return root.val + Math.max(leftPathSum, rightPathSum);  //max bcoz to identify the maximum path either on left or right from that node
    }

    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        findMaxSum(root, ans);
        return ans[0];
    }

    public static void main(String[] args) {

    }

    public static long findMaxSumPath(TreeNode root) {
        // Write your code here.
        long[] ans = new long[1];
        ans[0] = Long.MIN_VALUE;
        findMaxSum(root, ans);
        return ans[0];
    }

    private static long findMaxSum(TreeNode root, long[] maxi) {
        if (root == null) {
            return 0;
        }

        long leftPathSum = Math.max(0, findMaxSum(root.left, maxi));
        long rightPathSum = Math.max(0, findMaxSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], root.val + leftPathSum + rightPathSum);

        return root.val + Math.max(leftPathSum, rightPathSum);  //max bcoz to identify the maximum path either on left or right from that node
    }
}
