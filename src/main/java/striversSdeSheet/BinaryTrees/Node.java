package main.java.striversSdeSheet.BinaryTrees;

public class Node {

    public int data;
    public int hd; //horizontal distance
    public Node left, right;

    public Node next;

    Node(int data) {
        this.data = data;
        hd = Integer.MAX_VALUE;
        left = right = next = null;
    }
}
