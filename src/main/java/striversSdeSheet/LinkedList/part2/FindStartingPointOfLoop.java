package main.java.striversSdeSheet.LinkedList.part2;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class FindStartingPointOfLoop {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
