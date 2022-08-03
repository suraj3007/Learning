package main.java.striversSdeSheet.BinarySearchTree.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class SizeOfLargestBSTInBT {

    private static NodeValue largestBSTHelper(TreeNode<Integer> root) {

        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {
            return new NodeValue(Math.min(left.minNode, root.val), Math.max(right.maxNode, root.val),
                    left.maxSize + right.maxSize + 1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.maxSize, right.maxSize));
    }

    public static int largestBST(TreeNode<Integer> root) {
        // Write your code here.
        return largestBSTHelper(root).maxSize;
    }

    public static void main(String[] args) {

    }
}

class NodeValue {
    int minNode, maxNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}