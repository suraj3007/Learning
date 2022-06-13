package main.java.striversSdeSheet.LinkedList.part1;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class DeleteAGivenNodeWhenNodeIsGiven {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
