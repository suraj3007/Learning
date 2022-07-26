package main.java.striversSdeSheet.BinaryTrees.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class CheckIfBinaryTreeIsHeightBalanceOrNot {

    private int findHeight(TreeNode root) {
        if (root == null) return 0;

        int lh = findHeight(root.left);
        if (lh == -1) return -1;

        int rh = findHeight(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;
    }

    public static void main(String[] args) {

    }
}
