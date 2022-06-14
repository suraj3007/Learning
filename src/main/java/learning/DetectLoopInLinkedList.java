package main.java.learning;

import java.util.Set;
import java.util.HashSet;

public class DetectLoopInLinkedList {

    Node head;

    static class Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    private static void insert(DetectLoopInLinkedList list, int data) {
        Node newNode = new Node(data);
        Node currentNode = list.head;

        if (currentNode == null) {
            list.head = newNode;
        } else {
            //Inserting node at the beginning
            newNode.next = currentNode;
            list.head = newNode;
        }
    }

    private static void detectLoop(DetectLoopInLinkedList list) {
        Node slowPtr, fastPtr;
        slowPtr = fastPtr = list.head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                System.out.println("Loop detected...");
//                removeLoop(list, fastPtr);
                return;
            }
        }
        System.out.println("No loop found...");
    }

    private static void removeLoop(DetectLoopInLinkedList list, Node fastPtr) {
        Node slowPtr = list.head;
        Node prevNode = null;
        while (slowPtr != null) {
            if (fastPtr == slowPtr) {
                System.out.println("Removing loop..");
                prevNode.next = null;
                return;
            } else {
                slowPtr = slowPtr.next;
                prevNode = fastPtr;
                fastPtr = fastPtr.next;
            }
        }

    }

    private static void detectAndRemoveLoop(DetectLoopInLinkedList list) {
        Set<Node> nodeSet = new HashSet<>();
        Node currentNode = list.head;
        Node prevNode = null;

        while (currentNode != null) {

            if (nodeSet.contains(currentNode)) {
                System.out.println("Loop detected... Removing loop from the list");
                prevNode.next = null;
                return;
            } else {
                nodeSet.add(currentNode);
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        System.out.println("No loop detected...");
    }


    private static void printList(DetectLoopInLinkedList list) {
        Node currentNode = list.head;
        System.out.print("Values in list : ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DetectLoopInLinkedList list = new DetectLoopInLinkedList();

        insert(list, 45);
        insert(list, 67);
        insert(list, 34);
        insert(list, 22);
        insert(list, 89);

        printList(list);

//        list.head.next.next.next.next.next = list.head.next.next;

        list.head.next.next.next.next.next = list.head;

        detectLoop(list);

//        printList(list);

//        Second way..
        detectAndRemoveLoop(list);

        printList(list);

        //System.out.println(list.head.next.next.next.next.next);

    }
}
