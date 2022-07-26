package main.java.striversSdeSheet.BinaryTrees.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class HeightOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {

    }
}
