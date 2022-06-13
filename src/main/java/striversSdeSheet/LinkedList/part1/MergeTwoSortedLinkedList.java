package main.java.striversSdeSheet.LinkedList.part1;

import main.java.striversSdeSheet.LinkedList.ListNode;

public class MergeTwoSortedLinkedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        //To make sure that list1 is assigned to list which has smaller first value
        if (list1.val >= list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        //Smaller value will be of list1 as ensured above
        ListNode res = list1;

        while (list1 != null && list2 != null) {
            ListNode temp1 = null;
            while (list1 != null && list1.val <= list2.val) {
                //temp1 is used to remind last node of previous iteration
                temp1 = list1;
                list1 = list1.next;
            }
            //Above while loop can break if l2.val > current l1.val OR list 1 as null
            //It means next value will be l2.val, hence assigning to temp.next
            temp1.next = list2;

            //swap: to ensure next smaller value of list will marked as list1
            ListNode temp2 = list1;
            list1 = list2;
            list2 = temp2;

        }
        return res;
    }

    public static void main(String[] args) {

    }
}
