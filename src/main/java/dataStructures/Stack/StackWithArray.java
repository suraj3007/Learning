package main.java.dataStructures.Stack;

public class StackWithArray {

    static int top = -1;
    static int[] arr = new int[10];

    private static void push(int x) {
        if (top != arr.length - 1) {
            top++;
            arr[top] = x;
            System.out.println("Value added in the stack : " + x);
        } else {
            System.out.println("Stack is full.. Cannot add new items");
        }
    }

    private static void pop() {
        if (top != -1) {
            System.out.println("Value popped from the stack : " + arr[top]);
            top--;
        }else {
            System.out.println("Stack is empty.. No element to pop out of stack");
        }
    }

    private static void top() {
        if (top != -1) {
            System.out.println("Value at the top : " +arr[top]);
            return;
        }
        System.out.println("Stack is empty");
    }

    private static void isEmpty() {
        if (top != -1) {
            System.out.println("Stack is not empty");
            return;
        }
        System.out.println("Stack is empty");
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
    }
}
