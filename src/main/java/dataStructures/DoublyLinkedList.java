package main.java.dataStructures;

import java.util.Objects;

public class DoublyLinkedList {

    Node head;

    static class Node {
        int data;
        Node prevNode, nextNode;

        public Node(int data) {
            this.data = data;
        }
    }

    //Insertion
    private static void insert(DoublyLinkedList list, int i) {
        Node newNode = new Node(i);
        Node currentNode = list.head;

        //Case 1 : Insert as first element
        if (Objects.isNull(currentNode))
            list.head = newNode;
        else {
            while (Objects.nonNull(currentNode.nextNode)) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
            newNode.prevNode = currentNode;
        }
    }

    //Delete by key
    private static void deleteByKey(DoublyLinkedList list, int x) {

        Node currentNode = list.head;

        // CASE 1:
        // If head node itself holds the key to be deleted
        if (currentNode.data == x) {
            //if only 1 element present
            if (Objects.isNull(currentNode.nextNode) && Objects.isNull(currentNode.prevNode)) {
                System.out.println(x + " value found and deleted");
                list.head = null;
                return;
            }
            //if more than 1 element so shift head to next node
            System.out.println(x + " value found and deleted");
            list.head = currentNode.nextNode;
            currentNode.nextNode.prevNode = null;
            return;
        }

        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        while (Objects.nonNull(currentNode.nextNode) && currentNode.data != x) {
            currentNode = currentNode.nextNode;
        }

        if (currentNode.data == x) {
            System.out.println(x + " value found and deleted");

            currentNode.prevNode.nextNode = currentNode.nextNode;
            //To check if it is not the last element
            if (Objects.nonNull(currentNode.nextNode))
                currentNode.nextNode.prevNode = currentNode.prevNode;
        }

        // CASE 3: The key is not present
        if (Objects.isNull(currentNode.nextNode) && currentNode.data != x) {
            System.out.println(x + " value not found");
        }

    }

    //Delete at position
    private static void deleteAtPosition(DoublyLinkedList list, int index) {

        Node currentNode = list.head;
        int count = 0;

        if (index == 0) {
            if (Objects.isNull(currentNode.nextNode) && Objects.isNull(currentNode.prevNode)) {
                System.out.println("Value deleted at index : " + index);
                list.head = null;
                return;
            }
            System.out.println("Value deleted at index : " + index);
            list.head = currentNode.nextNode;
            currentNode.nextNode.prevNode = null;
            return;
        }

        while (Objects.nonNull(currentNode) && index != count) {
            currentNode = currentNode.nextNode;
            count++;
        }

        if (index == count) {
            System.out.println("Value deleted at index : " + index);
            currentNode.prevNode.nextNode = currentNode.nextNode;
            if (Objects.nonNull(currentNode.nextNode))
                currentNode.nextNode.prevNode = currentNode.prevNode;
        }

        if (Objects.isNull(currentNode)) {
            System.out.println("Index not found : " + index);
        }

    }

    //Print List
    private static void printList(DoublyLinkedList list) {
        Node currentNode = list.head;

        System.out.print("List values are : ");
        while (Objects.nonNull(currentNode)) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.nextNode;
        }
        System.out.println();
    }


    //TODO: Reverse LinkedList
    private static void reverseLinkedList(DoublyLinkedList list) {
        //Node currentNode = list.head;

    }

    //Main method
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        //
        // ******INSERTION******
        //

        // Insert the values
        insert(list, 1);
        insert(list, 2);
        insert(list, 3);
        insert(list, 4);
        insert(list, 5);
        insert(list, 6);
        insert(list, 7);
        insert(list, 8);
        insert(list, 9);

        // Print the LinkedList
        printList(list);

        //
        // ******DELETION BY KEY******
        //

        // Delete node with value 1
        // In this case the key is ***at head***
        deleteByKey(list, 1);

        // Print the LinkedList
        printList(list);

        // Delete node with value 4
        // In this case the key is present ***in the middle***
        deleteByKey(list, 4);

        // Print the LinkedList
        printList(list);

        // Delete node with value 4
        // In this case the key is present ***last element***
        deleteByKey(list, 8);

        // Print the LinkedList
        printList(list);

        // Delete node with value 10
        // In this case the key is ***not present***
        deleteByKey(list, 10);

        // Print the LinkedList
        printList(list);

        //
        // ******DELETION AT POSITION******
        //

        // Delete node at position 0
        // In this case the key is ***at head***
        deleteAtPosition(list, 0);

        // Print the LinkedList
        printList(list);

        // Delete node at position 2
        // In this case the key is present ***in the middle***
        deleteAtPosition(list, 2);

        // Print the LinkedList
        printList(list);

        // Delete node at last position
        // In this case the key is ***at head***
        deleteAtPosition(list, 3);

        // Print the LinkedList
        printList(list);

        // Delete node at position 10
        // In this case the key is ***not present***
        deleteAtPosition(list, 10);

        // Print the LinkedList
        printList(list);
//
//        //Reverse the LinkedList
//        reverseLinkedList(list);
//
//        printList(list);
    }
}