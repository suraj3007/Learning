package main.java.interview;

public class Turtlemint {

    static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // head1 :- 1 -> 2 -> 3 -> 4 -> 5 -> 6
    // head2 :- 7 -> 11 -> 9 -> 6

    //O(l1 + l2)
    //O(l1 + l2)

    private static LinkedList findIntersection(LinkedList head1, LinkedList head2) {
        if (head1 == null || head2 == null) {
            return null;
        }


        return null;
    }

    private static void printPattern(int layer) {
        String s = "****";
        for (int i = 1; i <= layer; i++) {
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern(4);
    }
}
