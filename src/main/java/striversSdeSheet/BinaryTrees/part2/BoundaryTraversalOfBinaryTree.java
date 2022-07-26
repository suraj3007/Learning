package main.java.striversSdeSheet.BinaryTrees.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static void addLeftBoundaries(TreeNode root, ArrayList<Integer> res) {
        TreeNode curr = root.left;
        while(curr != null) {
            if (!isLeaf(curr)) res.add(curr.val);
            if (curr.left != null) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
    }

    private static void addRightBoundaries(TreeNode root, ArrayList<Integer> res) {
        TreeNode curr = root.right;
        ArrayList<Integer> ds = new ArrayList<>();
        while(curr != null) {
            if (!isLeaf(curr)) ds.add(curr.val);
            if (curr.right != null) {
                curr = curr.right;
            }
            else {
                curr = curr.left;
            }
        }
        for (int i = ds.size() - 1; i >= 0; i--) {
            res.add(ds.get(i));
        }
    }

    private static void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        if (!isLeaf(root)) res.add(root.val);
        //Add left nodes
        addLeftBoundaries(root, res);
        //Add leaves
        addLeaves(root, res);
        //Add right nodes in reverse direction
        addRightBoundaries(root, res);
        return res;
    }
}
