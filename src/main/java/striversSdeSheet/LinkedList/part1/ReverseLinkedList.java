package main.java.striversSdeSheet.LinkedList.part1;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;  //Pointer to next node
            //Reversing the direction - first iteration to null & then next instance to previous node
            head.next = newHead;
            //Moving dummy node to current node to maintain the previous node address in singly linkedList
            //for next iteration
            newHead = head;
            //Moving head to next pointer
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode res = reverseList(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}