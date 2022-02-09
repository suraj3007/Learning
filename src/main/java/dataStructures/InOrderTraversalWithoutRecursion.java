package main.java.dataStructures;

import java.util.Stack;

public class InOrderTraversalWithoutRecursion {

    static Node root;

    static class Node {
        int data;
        Node left = null, right = null;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node insert(Node root, int x) {
        if (root == null) {
            root = new Node(x);
        } else if (x < root.data) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }
        return root;
    }

    private static void inOrderTraversalWithoutRecursion(Node root) {
        Stack stack = new Stack();
        if (root == null) {
            System.out.println("No nodes present in tree..");
            return;
        }
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = (Node) stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    private static void preOrderTraversalWithoutRecursion(Node root) {
        Stack stack = new Stack();
        if (root == null) {
            System.out.println("No nodes present in tree..");
            return;
        }
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.print(current.data + " ");
                stack.push(current);
                current = current.left;
            }
            current = (Node) stack.pop();
            current = current.right;
        }
    }

    private static void postOrderTraversalWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if (stack.empty())
                return;
            root = stack.pop();

            if (!stack.empty() && stack.peek() == root)
                root = root.right;
            else {
                System.out.print(root.data + " ");
                root = null;
            }
        }
    }

    public static void main(String[] args) {
        root = insert(root, 45);
        root = insert(root, 23);
        root = insert(root, 56);
        root = insert(root, 16);
        root = insert(root, 38);
        root = insert(root, 29);
        root = insert(root, 49);
        root = insert(root, 68);
        root = insert(root, 75);

        System.out.print("InOrder traversal : ");
        inOrderTraversalWithoutRecursion(root);
        System.out.println();

        System.out.print("PreOrder traversal : ");
        preOrderTraversalWithoutRecursion(root);
        System.out.println();

        System.out.print("PostOrder traversal : ");
        postOrderTraversalWithoutRecursion(root);
        System.out.println();
    }
}
