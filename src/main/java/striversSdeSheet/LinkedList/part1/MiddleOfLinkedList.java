package main.java.striversSdeSheet.LinkedList.part1;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode res = middleNode(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
