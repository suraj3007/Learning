package main.java.striversSdeSheet.BinarySearchTree.part2;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.Stack;

public class FindPairWithGivenSumInBST {

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) return false;

        BSTIterator2 l = new BSTIterator2(root, false);   //next
        BSTIterator2 r = new BSTIterator2(root, true);    //prev

        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

class BSTIterator2 {

    private Stack<TreeNode> stack = new Stack<>();
    private boolean isReverse;

    public BSTIterator2(TreeNode root, boolean isReverse){
        this.isReverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode tempNode = stack.pop();
        if (isReverse) {
            pushAll(tempNode.left);
        } else {
            pushAll(tempNode.right);
        }
        return tempNode.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (isReverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

}