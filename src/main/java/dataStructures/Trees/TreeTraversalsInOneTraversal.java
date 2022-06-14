package main.java.dataStructures.Trees;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

/**
 * Simple formula: -
 * Initialize stack with (root, 1). Keep popping value 1 by 1 and check below condition until stack is not empty.
 * if num == 1; add into preOrder; increment num & push again into stack; check if left available & add into stack.
 * if num == 2; add into inOrder; increment num & push again into stack; check if right available & add into stack.
 * if num == 3; add into postOrder;
 */
public class TreeTraversalsInOneTraversal {

    static Node root;

    static class Node {
        int data;
        Node prevNode;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.prevNode = null;
            this.nextNode = null;
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

    private static Node insert (Node root, int val) {
        if (Objects.isNull(root)) {
            root = new Node(val);
        } else if (val <= root.data) {
            root.prevNode = insert(root.prevNode, val);
        } else {
            root.nextNode = insert(root.nextNode, val);
        }
        return root;
    }

    private static void allTraversal(Node root) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.empty()) {
            Pair pair = stack.pop();

            // this is part of pre
            // increment 1 to 2
            // push the left side of the tree
            if (pair.num == 1) {
                preOrder.add(pair.node.data);
                pair.num++;
                stack.push(pair);
                if (pair.node.prevNode != null) {
                    stack.push(new Pair(pair.node.prevNode, 1));
                }
            }
            // this is a part of in
            // increment 2 to 3
            // push right
            else if (pair.num == 2) {
                inOrder.add(pair.node.data);
                pair.num++;
                stack.push(pair);
                if (pair.node.nextNode != null) {
                    stack.push(new Pair(pair.node.nextNode, 1));
                }
            }
            // don't push it back again
            else {
                postOrder.add(pair.node.data);
            }
        }

        System.out.print("PreOrder traversal: ");
        for (int i : preOrder) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("InOrder traversal: ");
        for (int i : inOrder) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("PostOrder traversal: ");
        for (int i : postOrder) {
            System.out.print(i + " ");
        }
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

        allTraversal(root);

//        PreOrder traversal: 45 23 16 38 29 56 49 68 75
//        InOrder traversal: 16 23 29 38 45 49 56 68 75
//        PostOrder traversal: 16 29 38 23 49 75 68 56 45
    }
}
