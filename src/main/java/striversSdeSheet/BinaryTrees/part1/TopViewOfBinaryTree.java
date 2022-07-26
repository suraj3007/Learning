package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.striversSdeSheet.BinaryTrees.Node;

import java.util.*;

public class TopViewOfBinaryTree {

    static class Pair{
        int hd;
        Node node;

        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        if (root == null) return ds;

        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int tempHd = temp.hd;
            Node tempNode = temp.node;

            if (!map.containsKey(tempHd)) {
                map.put(tempHd, tempNode.data);
            }

            if (tempNode.left != null) {
                queue.add(new Pair(tempNode.left, tempHd - 1));
            }

            if (tempNode.right != null) {
                queue.add(new Pair(tempNode.right, tempHd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ds.add(entry.getValue());
        }

        return ds;
    }

    public static void main(String[] args) {

    }
}
