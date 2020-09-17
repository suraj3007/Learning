package main.java.dataStructures;

import java.util.Objects;

public class BinarySearchTree {

    static Node root;

    static class Node {
        int data;
        Node prevNode = null, nextNode = null;

        public Node(int data) {
            this.data = data;
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

    private static void printTree() {

    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = null;
        root = insert(root, 15);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 25);
        root = insert(root, 8);
        root = insert(root, 12);
    }
}
