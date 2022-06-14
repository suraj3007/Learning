package main.java.dataStructures.Trees;

import java.util.Objects;

public class MaximumPathSumInBinaryTree {

    static Node root;
    static int maxValue2;

    static class Node {
        int data;
        Node prevNode;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.prevNode = null;
            this.nextNode = null;
        }
    }

    private static Node insert(Node root, int x) {
        if (Objects.isNull(root)) {
            root = new Node(x);
        } else if (x <= root.data) {
            root.prevNode = insert(root.prevNode, x);
        } else {
            root.nextNode = insert(root.nextNode, x);
        }
        return root;
    }

    private static int maximumPathDown(Node root, int[] maxValue) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int leftPathSum = Math.max(0, maximumPathDown(root.prevNode, maxValue));
        int rightPathSum = Math.max(0, maximumPathDown(root.nextNode, maxValue));
        maxValue[0] = Math.max(maxValue[0], leftPathSum + rightPathSum + root.data);
        //To return the maximum path value either left or right
        return Math.max(leftPathSum, rightPathSum) + root.data;
    }

    private static int maxPathSum(Node root) {
        int[] maxValue = new int[1];
        maximumPathDown(root, maxValue);
        return maxValue[0];
    }

    private static int maximumPathDown2(Node root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int leftPathSum = Math.max(0, maximumPathDown2(root.prevNode));
        int rightPathSum = Math.max(0, maximumPathDown2(root.nextNode));
        maxValue2 = Math.max(maxValue2, leftPathSum + rightPathSum + root.data);
        //To return the maximum path value either left or right
        return Math.max(leftPathSum, rightPathSum) + root.data;
    }

    public static void main(String[] args) {
        /**
         *              45
         *             / \
         *           23   56
         *          /  \ / \
         *        16  38 49 68
         *           /        \
         *          29         75
         */

        root = insert(root, 45);
        root = insert(root, 23);
        root = insert(root, 56);
        root = insert(root, 16);
        root = insert(root, 38);
        root = insert(root, 29);
        root = insert(root, 49);
        root = insert(root, 68);
        root = insert(root, 75);

        System.out.println("Diameter of binary tree: " +maxPathSum(root));
        maximumPathDown2(root);
        System.out.println("Diameter of binary tree: " +maxValue2);
    }
}
