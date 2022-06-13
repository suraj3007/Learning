package main.java.dataStructures;

import java.util.Objects;

public class CheckIfTreesAreIdentical {

    static Node root1;
    static Node root2;

    static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    private static Node insert(Node root, int x) {
        if(Objects.isNull(root)) {
            root = new Node(x);
        } else if (x <= root.data) {
            root.prev = insert(root.prev, x);
        } else {
            root.next = insert(root.next, x);
        }
        return root;
    }

    private static boolean isSameTree(Node p, Node q) {
        if (p == null || q == null) {
            return p == q;
        }
        return (p.data == q.data) && (isSameTree(p.prev, q.prev)) && (isSameTree(p.next, q.next));
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

        root1 = insert(root1, 45);
        root1 = insert(root1, 23);
        root1 = insert(root1, 56);
        root1 = insert(root1, 16);
        root1 = insert(root1, 38);
        root1 = insert(root1, 29);
        root1 = insert(root1, 49);
        root1 = insert(root1, 68);
        root1 = insert(root1, 75);

        root2 = insert(root2, 45);
        root2 = insert(root2, 23);
        root2 = insert(root2, 56);
        root2 = insert(root2, 16);
        root2 = insert(root2, 38);
        root2 = insert(root2, 29);
        root2 = insert(root2, 49);
        root2 = insert(root2, 68);
        root2 = insert(root2, 75);

        System.out.println(isSameTree(root1, root2) ?
                "Trees are identical" :
                "Trees are not identical");
    }
}
