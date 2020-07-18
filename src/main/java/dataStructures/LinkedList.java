package main.java.dataStructures;

import java.util.Objects;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = null;
        }
    }

    //Insertion
    protected static void insert(LinkedList list, int i) {
        Node newNode = new Node(i, null);

        //Case 1 : Insert as first element
        if (Objects.isNull(list.head)) {

            list.head = newNode;

        } else {

            //Case 2 : Traverse till last node and insert at the end
            Node currentNode = list.head;
            while (Objects.nonNull(currentNode.next)) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
    }

    //Delete by key
    private static void deleteByKey(LinkedList list, int x) {

        Node currentNode = list.head, previousNode = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted
        if (currentNode != null && currentNode.data == x) {
            System.out.println("Key " + x + " found and deleted");
            list.head = currentNode.next;
            return;
        }

        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (Objects.nonNull(currentNode) && currentNode.data != x) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (Objects.nonNull(currentNode)) {
            System.out.println("Key " + x + " found and deleted");
            previousNode.next = currentNode.next;
            return;
        }

        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (Objects.isNull(currentNode)) {
            System.out.println("Key : " + x + " not found");
        }

    }

    //Delete at position
    private static void deleteAtPosition(LinkedList list, int index) {

        Node currentNode = list.head, prevNode = null;
        int count = 0;

        // Case 1 : index = 0
        // Change the head from currentNode(first element) to next node.
        if (index == 0 && Objects.nonNull(currentNode)) {
            System.out.println(index + " position element deleted");
            list.head = currentNode.next;
            return;
        }

        // Case 2 : index > 0 & index < size of list
        //Traverse till index and remove the element from list
        while (Objects.nonNull(currentNode) && count != index) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            count++;
        }

        if (count == index) {
            System.out.println(index + " position element deleted");
            prevNode.next = currentNode.next;
            return;
        }

        // Case 3 : index > 0 & index > size of list
        //No operation performed
        if (Objects.isNull(currentNode)) {
            System.out.println(index + " position element not found");
        }
    }

    //Print List
    protected static void printList(LinkedList list) {
        Node currentNode = list.head;
        System.out.print("LinkedList values are : ");

        while (Objects.nonNull(currentNode)) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    //Reverse LinkedList
    private static void reverseLinkedList(LinkedList list) {
        Node currentNode = list.head, nextNode = null, prevNode = null;

        //Case 1: Only one element in list
        //Dont do anything just return as it is.
        if (Objects.isNull(currentNode.next)) {
            System.out.println("Only one element is present. So not reversing the list");
            return;
        } else {
            nextNode = currentNode.next;
            prevNode = currentNode;
            currentNode.next = null;

            while (Objects.nonNull(nextNode)) {
                currentNode = nextNode;
                nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
            }
            list.head = currentNode;
            System.out.println("List reversed...");
        }
    }

    //Main method
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

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

        // Delete node at position 10
        // In this case the key is ***not present***
        deleteAtPosition(list, 10);

        // Print the LinkedList
        printList(list);

        //Reverse the LinkedList
        reverseLinkedList(list);

        printList(list);
    }
}