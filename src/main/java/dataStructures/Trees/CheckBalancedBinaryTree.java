package main.java.dataStructures.Trees;

import java.util.Objects;

public class CheckBalancedBinaryTree {
    static Node root;

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

    private static int findHeight(Node root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int leftHeight = findHeight(root.prevNode);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = findHeight(root.nextNode);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static boolean isBalanced (Node root) {

        return findHeight(root) != -1;
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

        System.out.println(isBalanced(root) ?
                "Binary tree is balanced" :
                "Binary tree is not balanced");
    }
}
