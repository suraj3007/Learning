package main.java.striversSdeSheet.LinkedList.part1;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class RemoveNthNodeFromBackOfLinkedList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //dummy node which will contain the address of head
        //useful in edge cases like if we have to delete the nth node from back ie first node
        //slow will be at dummy node and by slow.next = slow.next.next; -> will give head next
        ListNode startNode = new ListNode();
        startNode.next = head;
        ListNode slow = startNode;
        ListNode fast = startNode;

        //Move fast pointer upto n times.
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        //Start moving fast and slow pointer by 1 step until fast.next != null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Break the link
        slow.next = slow.next.next;

        return startNode.next;
    }

    public static void main(String[] args) {

    }
}
