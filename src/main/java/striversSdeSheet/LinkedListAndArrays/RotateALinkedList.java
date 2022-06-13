package main.java.striversSdeSheet.LinkedListAndArrays;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class RotateALinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        //Compute the length of LL
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        //Pointing last node to first node as after rotating last node will point to first
        curr.next = head;

        //handling cases where k > len. Intuition: k's multiple will have original list after rotations.
        //if length is 5, so after 5, 10, 15th... rotation, it will be similar to original list.
        k = k % length;
        //go till that node ie. if len is 5 and rotation needed is 2, so we traverse till 3rd node
        //and do next step.
        k = length - k;
        while (k-- > 0) curr = curr.next;

        //make the node head and break the connection
        head = curr.next;
        curr.next =null;

        return head;
    }

    public static void main(String[] args) {

    }
}
