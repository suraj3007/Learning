package main.java.striversSdeSheet.StackAndQueue.part1;

import java.util.Stack;

//Time complexity : O(1) amortized
public class ImplementQueueUsingStack {

    static Stack<Integer> input = new Stack<>();
    static Stack<Integer> output = new Stack<>();

    private static void enqueue(int x) {
        input.push(x);
        System.out.println("Value added in queue : " +x);
    }

    private static void dequeue() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            System.out.println("Value removed from the queue: " +output.pop());
        } else {
            System.out.println("Value removed from the queue: " +output.pop());
        }
    }

    private static void top() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            System.out.println("Value present at the top: " +output.peek());
        } else {
            System.out.println("Value present at the top: " +output.peek());
        }
    }

    private static void isEmpty() {
        if (output.isEmpty() && input.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue is not empty");
    }

    public static void main(String[] args) {
        isEmpty();
        enqueue(4);
        enqueue(14);
        enqueue(24);
        enqueue(34);
        enqueue(44);
        enqueue(54);

        top();
        dequeue();
        top();
        isEmpty();
        enqueue(54);
        enqueue(64);
        top();
    }
}
