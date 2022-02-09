package main.java.learning1;

import main.java.dataStructures.LinkedList;

import java.util.Stack;

import static main.java.dataStructures.LinkedList.insert;
import static main.java.dataStructures.LinkedList.printList;
import static main.java.dataStructures.LinkedList.Node;

public class SumOfTwoLinkedListUsingStack {

    private static LinkedList addTwoListUsingStack (LinkedList list1, LinkedList list2) {
        LinkedList sumList = new LinkedList();

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();

        int carry = 0;

        fillStackFromList(stack1, list1);
        fillStackFromList(stack2, list2);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int value1 = 0, value2 = 0, sum;

            if (!stack1.isEmpty()) {
                value1 = (int) stack1.pop();
            }

            if (!stack2.isEmpty()) {
                value2 = (int) stack2.pop();
            }

            sum = value1 + value2 + carry;
            carry = sum / 10;
            stack3.push(sum % 10);
        }

        if (carry > 0)
            stack3.push(carry);

        while (!stack3.isEmpty()) {
            insert(sumList, (int) stack3.pop());
        }

        return sumList;
    }

    private static void fillStackFromList(Stack stack, LinkedList list) {
        Node node = list.head;
        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        insert(list1, 9);
        insert(list1, 9);
        insert(list1, 1);
        insert(list1, 7);
        insert(list1, 1);

        printList(list1);

        insert(list2, 9);
        insert(list2, 9);
        insert(list2, 8);

        printList(list2);

        LinkedList resultList = addTwoListUsingStack(list1, list2);

        printList(resultList);
    }
}
