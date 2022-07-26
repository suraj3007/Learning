package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.dataStructures.Trees.InOrderTraversalWithoutRecursion;
import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    private void findPostOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        findPostOrder(root.left, res);
        findPostOrder(root.right, res);
        res.add(root.val);
    }

    //Recursive approach
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        findPostOrder(root, res);
        return res;
    }

    //Iterative approach
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (root == null) return postOrder;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);

            if (root.left != null) stack1.push(root.left);
            if (root.right != null) stack1.push(root.right);
        }

        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop().val);
        }

        return postOrder;
    }
}
