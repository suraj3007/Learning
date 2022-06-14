package main.java.dataStructures.Trees;

import java.util.HashMap;

public class ConstructBinaryTree {

    static int preIndex = 0;
    static HashMap<Integer, Integer> inOrderMap = new HashMap<>();

    static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    private static Node constructTree(int[] in, int[] pre, int start, int end) {
        if (start > end)
            return null;

        Node newNode = new Node(pre[preIndex++]);

        if(start == end)
            return newNode;

        int inIndex = inOrderMap.get(newNode.data);

        newNode.prev = constructTree(in, pre, start, inIndex - 1);
        newNode.next = constructTree(in, pre, inIndex + 1, end);

        return newNode;
    }

    //Left, Root, Right
    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.prev);
        System.out.print(root.data + " ");
        inOrderTraversal(root.next);
    }

    public static void main(String[] args) {
        int[] inOrder = {16, 23, 29, 38, 45, 49, 56, 68, 75};
        int[] preOrder = {45, 23, 16, 38, 29, 56, 49, 68, 75};

        int length = inOrder.length;
        for (int i = 0; i < length; i++)
            inOrderMap.put(inOrder[i], i);

        Node root = constructTree(inOrder, preOrder, 0, length - 1);

        System.out.print("InOrder traversal : ");
        inOrderTraversal(root);
        System.out.println();

    }
}
