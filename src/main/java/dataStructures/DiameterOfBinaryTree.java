package main.java.dataStructures;

import java.util.Objects;

public class DiameterOfBinaryTree {

    static Node root;
    static int max = 0;

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

    private static int findDiameter (Node root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int leftHeight = findDiameter(root.prevNode);
        int rightHeight = findDiameter(root.nextNode);

        max = Math.max(max, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private static int height(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.prevNode, diameter);
        int rh = height(node.nextNode, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
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

        System.out.println("Diameter of binary tree: " +diameterOfBinaryTree(root));
        findDiameter(root);
        System.out.println("Diameter of binary tree: " +max);
    }
}
