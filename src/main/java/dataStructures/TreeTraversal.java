package main.java.dataStructures;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 *              45
 *             / \
 *           23   56
 *          /  \ / \
 *        16  38 49 68
 *           /        \
 *          29         75
 */

public class TreeTraversal {

    static Node root;

    static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    private static Node insert(Node root, int x) {
        if (Objects.isNull(root)) {
            root = new Node(x);
        } else if (x <= root.data) {
            root.prev = insert(root.prev, x);
        } else {
            root.next = insert(root.next, x);
        }
        return root;
    }

    /**
     * Depth first traversal : InOrder, PreOrder, PostOrder
     * @param root
     */

    //Left, Root, Right
    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.prev);
        System.out.print(root.data + " ");
        inOrderTraversal(root.next);
    }

    //Root, Left, Right
    private static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.prev);
        preOrderTraversal(root.next);
    }

    //Left, Right, Root
    private static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.prev);
        postOrderTraversal(root.next);
        System.out.print(root.data + " ");
    }

    //Breadth first traversal
    private static void levelOrderTraversal (Node root) {
        Node temp = root;
        Queue<Node> queue = new LinkedList();

        while(temp != null) {
            System.out.print(temp.data + " ");

            if(temp.prev != null) {
                queue.add(temp.prev);
            }
            if(temp.next != null) {
                queue.add(temp.next);
            }
            temp = queue.poll();
        }

    }

    private static int findHeightOfTree(Node root) {
        /**
         *              45
         *             / \
         *           23   56
         *          /  \ / \
         *        16  38 49 68
         *           /        \
         *          29         75
         */

        if(root == null) {
            return -1;
        } else {
            int leftHeight = findHeightOfTree(root.prev);
            int rightHeight = findHeightOfTree(root.next);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
//        TreeTraversal tree = new TreeTraversal();
//        tree.root = new Node(1);
//        tree.root.prev = new Node(2);
//        tree.root.next = new Node(3);
//        tree.root.prev.prev = new Node(4);
//        tree.root.prev.next = new Node(5);

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
        inOrderTraversal(root);
        System.out.println();

        System.out.print("\nPreOrder traversal : ");
        preOrderTraversal(root);
        System.out.println();

        System.out.print("\nPostOrder traversal : ");
        postOrderTraversal(root);
        System.out.println();

        System.out.print("\nLevelOrder traversal : ");
        levelOrderTraversal(root);
        System.out.println();

        int n = findHeightOfTree(root);
        System.out.println("\nHeight of tree : " +n);

    }
}
