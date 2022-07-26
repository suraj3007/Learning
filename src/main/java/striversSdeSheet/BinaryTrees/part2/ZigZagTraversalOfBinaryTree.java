package main.java.striversSdeSheet.BinaryTrees.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversalOfBinaryTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;

        if (root == null) return res;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ds = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if(flag) {
                    ds.add(node.val);
                } else {
                    ds.add(0, node.val);
                }
            }

            flag = !flag;
            res.add(ds);
        }


        return res;
    }

    public static void main(String[] args) {

    }
}
