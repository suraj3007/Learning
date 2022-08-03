package main.java.striversSdeSheet.BinarySearchTree.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class MaximumSumBSTInBT {

    private T traverse(TreeNode root, int[] ans) {
        if (root == null)
            return new T(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        T left = traverse(root.left, ans);
        T right = traverse(root.right, ans);

        //Boundary conditions as per SizeOfLargestBSTInBT.java
        if (!left.isBST || !right.isBST || root.val <= left.max || root.val >= right.min)
            return new T();

        // root is a valid BST
        final int sum = root.val + left.sum + right.sum;
        ans[0] = Math.max(ans[0], sum);
        return new T(true, Math.max(root.val, right.max), Math.min(root.val, left.min), sum);
    }

    public int maxSumBST(TreeNode root) {
        int[] ans = new int[]{0};
        traverse(root, ans);
        return ans[0];
    }

    public static void main(String[] args) {

    }
}

class T {
    public boolean isBST;
    public Integer max;
    public Integer min;
    public Integer sum;
    public T() {
        this.isBST = false;
        this.max = null;
        this.min = null;
        this.sum = null;
    }
    public T(boolean isBST, int max, int min, int sum) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}