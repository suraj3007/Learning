package main.java.striversSdeSheet.LinkedList.part2;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class CheckIfListIsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null || head == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        //find middle of linkedList
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the right half
        slow.next = reverseList(slow.next);
        //move slow to right half
        slow = slow.next;
        //Check for left & right half value
        while (slow != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
