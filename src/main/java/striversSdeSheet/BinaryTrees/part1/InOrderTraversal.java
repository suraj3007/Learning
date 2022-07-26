package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    private void findInOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        findInOrder(root.left, res);
        res.add(root.val);
        findInOrder(root.right, res);
    }

    //Recursive approach
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        findInOrder(root, res);
        return res;
    }

    //IterativeApproach
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                inOrder.add(node.val);
                node = node.right;
            }
        }

        return inOrder;
    }

    public static void main(String[] args) {

    }
}
