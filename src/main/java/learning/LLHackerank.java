package main.java.learning;

import java.io.*;
import java.util.ArrayList;

class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        ArrayList<SinglyLinkedListNode> nodeList = new ArrayList<>();
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            SinglyLinkedListNode temp = null;
            while (head != null) {
                nodeList.add(head);
                temp = head;
                head = head.next;
            }
            temp.next = newNode;
        }
        nodeList.add(head);
        return nodeList.get(0);
    }


    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        int[] llistCount = {141, 302, 164, 530, 474};

        for (int i = 0; i < llistCount.length; i++) {

            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistCount[i]);
            llist.head = llist_head;

        }
    }
}
