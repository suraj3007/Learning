package main.java.striversSdeSheet.BinaryTrees.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class DiameterOfBinaryTree {

    private int findHeight(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int lh = findHeight(root.left, diameter);
        int rh = findHeight(root.right, diameter);
        //find longest path by adding height of left and right subtree.
        diameter[0] = Math.max(diameter[0], lh + rh);

        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        findHeight(root, diameter);
        return diameter[0];
    }

    public static void main(String[] args) {

    }
}
