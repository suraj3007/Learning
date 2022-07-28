package main.java.striversSdeSheet.BinaryTrees;

public class BinaryTreeNode<K> {

    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int data) { this.data = data; }
    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
