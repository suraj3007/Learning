package main.java.striversSdeSheet.StackAndQueue.part1;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementQueueUsingArray {

    static int front = 0, rear = 0, count = 0, maxSize = 5;
    static int[] arr = new int[maxSize];

    private static void enqueue(int x) {
        if (count == maxSize) {
            System.out.println("Queue is full. Cannot add : " +x);
            return;
        }
        arr[rear % maxSize] = x;
        rear++;
        count++;
        System.out.println("Value added in queue : " +x);
    }

    private static void dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Value dequeued from the queue : " +arr[front % maxSize]);
        arr[front % maxSize] = -1;
        front++;
        count--;
    }

    private static void top() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Value at the top : " +arr[front % maxSize]);
    }

    private static void isEmpty() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue is not empty");
    }

    private static void print() {
        if (count == 0) {
            System.out.println("Queue is empty.. Nothing to print");
            return;
        }
        System.out.println("Elements in the queues are : ");
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i % maxSize] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        isEmpty();
        enqueue(4);
        enqueue(14);
        enqueue(24);
        enqueue(34);
        enqueue(44);
        enqueue(54);
        print();

        top();
        dequeue();
        top();
        isEmpty();
        enqueue(54);
        enqueue(64);
        top();
        print();
    }
}
