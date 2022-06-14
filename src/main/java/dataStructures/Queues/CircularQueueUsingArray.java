package main.java.dataStructures.Queues;

public class CircularQueueUsingArray {

    static int front = -1, rear = -1;
    static int[] arr = new int[10];

    private static void enqueue(int x) {

        if ((rear + 1) % arr.length == front) {
            System.out.println("Queue is full.. Cannot enter the value : " + x + " in queue");
            return;
        } else if (front == -1 && rear == -1) {
            front++;
            rear++;
        } else {
            rear = (rear + 1) % arr.length;
        }
        arr[rear] = x;
        System.out.println("Value enqueued : " + x);
    }

    private static void dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty.. Nothing to dequeue");
        } else if (front == rear) {
            System.out.println("Value dequeued : " + arr[front]);
            front = rear = -1;
        } else {
            front = front % arr.length;
            System.out.println("Value dequeued : " + arr[front]);
            front++;
        }
    }

    private static void front() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Value at the front : " +arr[front]);
        }
    }

    private static void isEmpty() {
        System.out.println(front == -1 ?
                "Queue is empty..." : "Queue is not empty");
    }

    private static void printQueue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty. Nothing to print...");
            return;
        } else if (front == rear) {
            System.out.print("Element present in queue : " + arr[front]);
            System.out.println();
            return;
        } else if (rear > front) {
            System.out.print("Elements present in queue : ");
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.print("Elements present in queue : ");
            for (int i = front; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        isEmpty();
        dequeue();

        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);
        enqueue(6);
        enqueue(7);
        enqueue(8);
        enqueue(9);
        enqueue(10);
        enqueue(11);

        front();
        isEmpty();
        printQueue();

        dequeue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();

        printQueue();
        isEmpty();
        front();

        enqueue(11);
        enqueue(12);
        enqueue(13);

        isEmpty();
        printQueue();
        front();

        dequeue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();
//        dequeue();
//        dequeue();

        printQueue();
        isEmpty();
        front();
    }


}
