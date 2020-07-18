package main.java.dataStructures;

import java.util.Objects;

public class StackWithLinkedList {

    Node top;

    static class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void push(StackWithLinkedList linkedList, int x) {
        Node node = new Node(x);
        if (Objects.isNull(linkedList.top)) {
            linkedList.top = node;
            System.out.println("Value added to the stack : " + linkedList.top.data);
        } else {
            node.next = linkedList.top;
            linkedList.top = node;
            System.out.println("Value added to the stack : " + linkedList.top.data);
        }
    }

    private static void pop(StackWithLinkedList linkedList) {
        if (Objects.isNull(linkedList.top)){
            System.out.println("Stack is empty.. Cant pop value from the stack");
        }else {
            System.out.println("Value popped from the stack : " + linkedList.top.data);
            linkedList.top = linkedList.top.next;
        }
    }

    private static void top(StackWithLinkedList linkedList) {
        if (Objects.isNull(linkedList.top)){
            System.out.println("Stack is empty..");
        }else {
            System.out.println("Value present on the top : " + linkedList.top.data);
        }
    }

    private static void isEmpty(StackWithLinkedList linkedList) {
        if (Objects.isNull(linkedList.top)){
            System.out.println("Stack is empty..");
            return;
        }
        System.out.println("Stack is not empty");
    }

    private static void printList(StackWithLinkedList linkedList) {
        Node head = linkedList.top;
        System.out.print("Values in the stack are : ");
        while (Objects.nonNull(head)) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackWithLinkedList linkedList = new StackWithLinkedList();

        isEmpty(linkedList);

        push(linkedList,1);
        push(linkedList, 2);
        push(linkedList, 3);
        printList(linkedList);

        pop(linkedList);
        printList(linkedList);

        push(linkedList,4);
        push(linkedList,5);
        printList(linkedList);

        top(linkedList);

        isEmpty(linkedList);

        pop(linkedList);
        printList(linkedList);

        push(linkedList,6);
        push(linkedList,7);
        push(linkedList,8);
        push(linkedList, 9);
        push(linkedList, 10);
        push(linkedList, 11);

        top(linkedList);

        push(linkedList,12);
        push(linkedList,13);

        top(linkedList);
        pop(linkedList);
        printList(linkedList);
    }
}
