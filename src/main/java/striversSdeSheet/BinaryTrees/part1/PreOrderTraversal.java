package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    private void findPreOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        findPreOrder(root.left, res);
        findPreOrder(root.right, res);
    }

    //Recursive approach
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        findPreOrder(root, res);
        return res;
    }

    //Iterative approach
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                preOrder.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                node = node.right;
            }
        }

        return preOrder;
    }

    public static void main(String[] args) {

    }
}
