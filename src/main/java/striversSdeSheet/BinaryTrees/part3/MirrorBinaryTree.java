package main.java.striversSdeSheet.BinaryTrees.part3;

import main.java.striversSdeSheet.BinaryTrees.Node;

public class MirrorBinaryTree {

    private Node mirrorNode(Node node) {
        if (node == null) return null;
        Node temp = node.left;
        node.left = mirrorNode(node.right);
        node.right = mirrorNode(temp);
        return node;
    }

    void mirror(Node node) {
        // Your code here
        mirrorNode(node);
    }

    public static void main(String[] args) {

    }
}
