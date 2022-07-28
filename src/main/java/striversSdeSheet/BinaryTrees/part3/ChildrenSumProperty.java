package main.java.striversSdeSheet.BinaryTrees.part3;

import main.java.striversSdeSheet.BinaryTrees.BinaryTreeNode;

public class ChildrenSumProperty {

    public static void changeTree(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null) return;
        int child = 0;
        if (root.left != null) child += root.left.data;
        if (root.right != null) child += root.right.data;

        if (child >= root.data) root.data = child;
        else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.left != null || root.right != null) {
            root.data = total;
        }
    }

    public static void main(String[] args) {

    }
}
