package main.java.dataStructures.Stack;

import main.java.dataStructures.LinkedList.LinkedList;

import java.util.Objects;
import java.util.Stack;

import static main.java.dataStructures.LinkedList.LinkedList.insert;
import static main.java.dataStructures.LinkedList.LinkedList.printList;

public class ReverseLinkedListUsingStack {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        insert(list, 1);
        insert(list, 2);
        insert(list, 3);
        insert(list, 4);
        insert(list, 5);
        insert(list, 6);

        printList(list);

        reverseListUsingStack(list);

        printList(list);

    }

    private static void reverseListUsingStack(LinkedList list) {
        Stack stack = new Stack();
        LinkedList.Node node = list.head;

        if (Objects.nonNull(node) && Objects.isNull(node.next)) {
            System.out.println("Only 1 element present in the list.. so not reversing the list");
            return;
        }

        while (Objects.nonNull(node)){
            stack.push(node);
            node = node.next;
        }

        list.head = (LinkedList.Node) stack.pop();
        LinkedList.Node temp = null;
        while (!stack.isEmpty()) {
            temp = (LinkedList.Node) stack.pop();
            temp.next.next = temp;
        }
        temp.next = null;
        System.out.println("List reversed");
    }
}
