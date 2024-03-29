package main.java.striversSdeSheet.BinaryTrees.part1;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class WidthOfBinaryTree {

    static Node root;

    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class Pair {
        Node node;
        int num;

        public Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    private static Node insert(Node root, int x) {
        if (Objects.isNull(root)) {
            root = new Node(x);
        } else if (x <= root.data) {
            root.prev = insert(root.prev, x);
        } else {
            root.next = insert(root.next, x);
        }
        return root;
    }

    //Applying level order traversal
    private static int maxWidth(Node root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().num; //to make the id starting from zero
            int first = 0, last = 0;
            /** Indexes: -
             *              0
             *             / \
             *           1   2
             *          / \ / \
             *         1  2 3 4
             *           /     \
             *          3       8
             */
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int curr = pair.num - min;  //It will ensure id starting from zero
                Node node = pair.node;
                if (i == 0) {
                    first = curr;   //Actual indexing takes place here. We just intend to find first & last
                }
                if (i == size - 1) {
                    last = curr;    //finding last. In b/w first & last, indexing is not relevant as per formula
                }
                if (node.prev != null) {
                    //indexing formula for left node when 1-based indexing is used.
                    queue.add(new Pair(node.prev, curr*2+1));
                }
                if (node.next != null) {
                    //indexing formula for right node when 1-based indexing is used.
                    queue.add(new Pair(node.next, curr*2+2));
                }
            }
            ans = Math.max(ans, last - first + 1); //Last index - first index + 1 -> max width b/w 2 nodes inclusive
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         *              45
         *             / \
         *           23   56
         *          /  \ / \
         *        16  38 49 68
         *           /        \
         *          29         75
         */

        root = insert(root, 45);
        root = insert(root, 23);
        root = insert(root, 56);
        root = insert(root, 16);
        root = insert(root, 38);
        root = insert(root, 29);
        root = insert(root, 49);
        root = insert(root, 68);
        root = insert(root, 75);

        //Answer is 6 because max width is calculated b/w 2 available nodes. Here, 2 nodes are 29 & 75
        System.out.println("Maximum width of binary tree: " +maxWidth(root));
    }
}
