package main.java.striversSdeSheet.LinkedList.part2;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class FindIntersectionOfLinkedList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            //For the end of first iteration, we just reset the pointer to the head of another linkedList
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(-1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(-1);

        System.out.println(getIntersectionNode(head1, head2).val);
    }
}
