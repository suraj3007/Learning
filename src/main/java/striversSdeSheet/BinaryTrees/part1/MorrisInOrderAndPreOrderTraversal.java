package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderAndPreOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inOrder.add(curr.val); //root added. Wo root node add hoga jiska left node null hai
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inOrder.add(curr.val); //root added. Wo root node add hoga jiska left traversal complete ho chuka ho
                    curr = curr.right;
                }
            }
        }
        return inOrder;
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                preOrder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    //thread banane k bad add root node immediately. because this is the moment you are at root node.
                    //and will move on to left side. PreOrder is Root-L-R. So, adding root and moving left. barabar?
                    preOrder.add(curr.val);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }

        }

        return preOrder;
    }

    public static void main(String[] args) {

    }
}
