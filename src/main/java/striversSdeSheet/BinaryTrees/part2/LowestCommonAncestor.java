package main.java.striversSdeSheet.BinaryTrees.part2;

import java.util.Objects;

public class LowestCommonAncestor {

    static Node root;

    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private static Node insert(Node root, int data) {
        if (Objects.isNull(root)) {
            root = new Node(data);
        } else if (data <= root.data) {
            root.prev = insert(root.prev, data);
        } else {
            root.next = insert(root.next, data);
        }
        return root;
    }

    private static Node lca(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = lca(root.prev, p, q);
        Node right = lca(root.next, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {    //both left and right are not null then we found our result.
            return root;
        }
    }

    private static Node lca2(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        Node left = lca2(root.prev, p, q);
        Node right = lca2(root.next, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {    //both left and right are not null then we found our result.
            return root;
        }
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

        Node lca = lca2(root, 49, 75);
        System.out.println("LCA: " +lca.data);
    }
}
