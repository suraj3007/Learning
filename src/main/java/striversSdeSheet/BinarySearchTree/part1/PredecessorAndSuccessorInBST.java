package main.java.striversSdeSheet.BinarySearchTree.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class PredecessorAndSuccessorInBST {

    public static ArrayList<Integer> predecessorSuccessor(TreeNode<Integer> root, int key) {
        // Write your code here.
        TreeNode<Integer> tempRoot = root;
        int successor = -1;
        int predecessor = -1;
        while (tempRoot != null) {
            if (key >= tempRoot.val) {
                tempRoot = tempRoot.right;
            } else {
                successor = tempRoot.val;
                tempRoot = tempRoot.left;
            }
        }

        tempRoot = root;

        while (tempRoot != null) {
            if (key <= tempRoot.val) {
                tempRoot = tempRoot.left;
            } else {
                predecessor = tempRoot.val;
                tempRoot = tempRoot.right;
            }
        }

        return new ArrayList<>(Arrays.asList(predecessor, successor));
    }

    public static void main(String[] args) {

    }
}
