package main.java.dataStructures;

import java.util.ArrayList;
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

    private static boolean search(Node root, int x) {
        if (Objects.isNull(root)) {
            return false;
        } else if (x < root.data) {
            return search(root.prevNode, x);
        } else if (x > root.data) {
            return search(root.nextNode, x);
        } else
            return true;
    }

    private static Node delete(Node root, int x) {
        if (root == null) {
            return root;
        } else if (x < root.data) {
            root.prevNode = delete(root.prevNode, x);
        } else if (x > root.data) {
            root.nextNode = delete(root.nextNode, x);
        } else {
            System.out.println();
            //Case 1 : Delete leaf node
            if (root.prevNode == null && root.nextNode == null) {
                root = null;
            }
            //Case 2 : Only 1 child i.e. either left or right child
            else if (root.prevNode == null) {
                root = root.nextNode;
            } else if (root.nextNode == null) {
                root = root.prevNode;
            } else {
                //Case 3 : 2 child
                ArrayList<Integer> arr = new ArrayList<>();
                findInorder(root, arr);
                int val = arr.get(arr.indexOf(x) + 1);
                root.data = val;
                delete(root.nextNode, val);
            }
        }
        return root;
    }

    private static void findInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        findInorder(root.prevNode, arr);
        arr.add(root.data);
        findInorder(root.nextNode, arr);
    }

    //Left Root Right
    private static void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.prevNode);
        System.out.print(root.data + " ");
        inOrderTraversal(root.nextNode);
    }

    public static void main(String[] args) {

        /* Let us create following BST
              50
            /    \
          30      70
         /  \    /  \
        20   40  60  80 */

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 80);
        root = insert(root, 60);

        System.out.println(search(root, 70) ?
                "Element is present in a tree..." :
                "Element is not present in a tree..");

        System.out.print("\nInorder traversal of the modified tree : ");
        inOrderTraversal(root);

        //Deleting leaf node
        System.out.println("\nDeleting 20...");
        root = delete(root, 20);

        System.out.print("\nInorder traversal of the modified tree : ");
        inOrderTraversal(root);

        //Deleting node with one child
        System.out.println("\nDeleting 30...");
        root = delete(root, 30);

        System.out.print("\nInorder traversal of the modified tree : ");
        inOrderTraversal(root);

        //Deleting node with 2 child
        System.out.println("\nDeleting 50...");
        root = delete(root, 50);

        System.out.print("\nInorder traversal of the modified tree : ");
        inOrderTraversal(root);

        //Node not present
        System.out.println("\nDeleting 100...");
        root = delete(root, 100);

        System.out.print("\nInorder traversal of the modified tree : ");
        inOrderTraversal(root);
    }


}
