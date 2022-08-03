package main.java.striversSdeSheet.BinarySearchTree.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.Stack;

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
