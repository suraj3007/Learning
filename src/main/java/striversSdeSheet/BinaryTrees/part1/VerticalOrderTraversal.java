package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    static class Tuple{
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ds = new ArrayList<>();

        if(root == null) return ds;
        queue.add(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            root = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x)) map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(root.val);

            if (root.left != null) {
                queue.add(new Tuple(root.left, x - 1, y + 1));
            }

            if (root.right != null) {
                queue.add(new Tuple(root.right, x + 1, y + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> entry : map.values()) {
            ds.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : entry.values()) {
                while(!nodes.isEmpty()) {
                    ds.get(ds.size() - 1).add(nodes.poll());
                }
            }
        }
        return ds;
    }

    public static void main(String[] args) {

    }
}
