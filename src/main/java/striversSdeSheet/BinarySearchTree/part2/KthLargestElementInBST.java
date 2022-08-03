package main.java.striversSdeSheet.BinarySearchTree.part2;

import main.java.striversSdeSheet.BinaryTrees.Node;
import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.Stack;

public class KthLargestElementInBST {

    public int kthLargest(Node root, int K)
    {
        //Your code here
        Stack<Node> stack = new Stack<>();
        while(true) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                if (--K == 0) {
                    return root.data;
                }
                root = root.left;
            }
        }
    }

    public static void main(String[] args) {

    }
}
