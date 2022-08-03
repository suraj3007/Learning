package main.java.striversSdeSheet.BinarySearchTree.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class ValidateBST {

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;

        if (root.val >= maxVal || root.val <= minVal) return false;

        return isValidBST(root.left, minVal, root.val) &&
                isValidBST(root.right, root.val, maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {

    }

}
