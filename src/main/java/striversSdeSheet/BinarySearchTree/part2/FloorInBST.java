package main.java.striversSdeSheet.BinarySearchTree.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class FloorInBST {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int floorValue = -1;

        while (root != null) {
            if (X < root.val) {
                root = root.left;
            } else {
                floorValue = root.val;
                root = root.right;
            }
        }

        return floorValue;
    }

    public static void main(String[] args) {

    }
}
