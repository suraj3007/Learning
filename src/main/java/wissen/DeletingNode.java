package main.java.wissen;

import java.util.Objects;

public class DeletingNode {

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        //if list is empty.
        SinglyLinkedListNode headNode = llist;
        if(Objects.isNull(llist)) {
            return null;
        } else {
            while(Objects.nonNull(llist.next)) {
                int index = 0;
                //if we have to delete the first node
                if(position == 0) {
                    return llist.next;
                } else {
                    //traverse to position
                    SinglyLinkedListNode prevNode = llist;
                    llist = llist.next;
                    index++;
                    if(index == position) {
                        prevNode.next = llist.next;
                        break;
                    }
                }
            }
        }
        return headNode;
    }

    private static SinglyLinkedListNode traverseListToPosition(SinglyLinkedListNode llist, int position) {
        SinglyLinkedListNode headNode = llist;
        int index = 0;
        SinglyLinkedListNode prevNode = llist;
        llist = llist.next;
        index++;
        if(index == position) {
            prevNode.next = llist.next;
        }
        return headNode;
    }
}

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}
