package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;

public class LeftViewOfBinaryTree {

    private void findLeftView(TreeNode root, ArrayList<Integer> ds, int currentDepth) {
        if (root == null) {
            return;
        }
        if (currentDepth == ds.size()) {
            ds.add(root.val);
        }
        findLeftView(root.left, ds, currentDepth + 1);
        findLeftView(root.right, ds, currentDepth + 1);
    }

    ArrayList<Integer> leftView(TreeNode root)
    {
        // Your code here
        ArrayList<Integer> ds = new ArrayList<>();
        findLeftView(root, ds, 0);
        return ds;
    }

    public static void main(String[] args) {

    }

    private void findRightView(TreeNode root, ArrayList<Integer> ds, int currentDepth) {
        if (root == null) {
            return;
        }
        if (currentDepth == ds.size()) {
            ds.add(root.val);
        }
        findRightView(root.right, ds, currentDepth + 1);
        findRightView(root.left, ds, currentDepth + 1);
    }

    ArrayList<Integer> rightView(TreeNode root)
    {
        // Your code here
        ArrayList<Integer> ds = new ArrayList<>();
        findRightView(root, ds, 0);
        return ds;
    }
}
