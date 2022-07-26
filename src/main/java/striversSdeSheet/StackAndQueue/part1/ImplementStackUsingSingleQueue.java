package main.java.striversSdeSheet.StackAndQueue.part1;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingSingleQueue {

    static Queue<Integer> queue = new LinkedList<>();

    private static void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        System.out.println("Value added in the stack : " +x);
    }

    private static void pop() {
        if (!queue.isEmpty()) {
            System.out.println("Element removed from the stack : " +queue.poll());
        } else {
            System.out.println("Stack is empty. Nothing to pop");
        }
    }

    private static void top() {
        if (!queue.isEmpty()) {
            System.out.println("Element present at the top of stack : " +queue.peek());
        } else {
            System.out.println("Stack is empty");
        }
    }

    private static void isEmpty() {
        if (!queue.isEmpty()) {
            System.out.println("Stack is not empty");
        } else {
            System.out.println("Stack is empty");
        }
    }

    public static void main(String[] args) {
        isEmpty();

        push(1);
        push(2);
        push(3);

        pop();

        push(4);
        push(5);

        top();

        isEmpty();

        pop();

        push(6);
        push(7);
        push(8);
        push(9);
        push(10);
        push(11);

        top();

        push(12);
        push(13);

        top();
        pop();
        top();
    }
}
