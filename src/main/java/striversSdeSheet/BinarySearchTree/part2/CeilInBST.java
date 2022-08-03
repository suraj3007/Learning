package main.java.striversSdeSheet.BinarySearchTree.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class CeilInBST {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
        int ceil = -1;
        while(node != null) {
            if (x > node.val) {
                node = node.right;
            } else {
                ceil = node.val;
                node = node.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {

    }
}
