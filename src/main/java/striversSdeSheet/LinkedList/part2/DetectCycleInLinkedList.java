package main.java.striversSdeSheet.LinkedList.part2;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class DetectCycleInLinkedList {

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
