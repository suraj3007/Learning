package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.striversSdeSheet.BinaryTrees.Node;

import java.util.*;

public class BottomViewOfBinaryTree {

    public ArrayList<Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ds = new ArrayList<>();
        if (root == null) return ds;
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        root.hd = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int tempHd = temp.hd;
            map.put(tempHd, temp.data);

            if (temp.left != null) {
                temp.left.hd = tempHd - 1;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = tempHd + 1;
                queue.add(temp.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            ds.add(entry.getValue());
        }
        return ds;
    }

    public static void main(String[] args) {

    }
}
