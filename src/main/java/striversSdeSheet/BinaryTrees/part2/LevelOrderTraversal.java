package main.java.striversSdeSheet.BinaryTrees.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ds.add(node.val);

                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(ds);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
