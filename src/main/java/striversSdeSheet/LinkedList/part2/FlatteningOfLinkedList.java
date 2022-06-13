package main.java.striversSdeSheet.LinkedList.part2;

public class FlatteningOfLinkedList {

    Node flatten(Node root)
    {
        if (root == null || root.next == null) return root;

        root.next = flatten(root.next);
        root = mergeLinkedList(root, root.next);

        return root;
    }

    Node mergeLinkedList(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = b;
                b = b.bottom;
            }
        }
        temp.bottom = a != null ? a : b;
        return res.bottom;
    }

    public static void main(String[] args) {

    }
}

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
