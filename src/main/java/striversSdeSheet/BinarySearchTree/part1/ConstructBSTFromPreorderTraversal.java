package main.java.striversSdeSheet.BinarySearchTree.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

public class ConstructBSTFromPreorderTraversal {

    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left =  bstFromPreorder(preorder, root.val, i);
        root.right =  bstFromPreorder(preorder, bound, i);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[1]);
    }

    public static void main(String[] args) {

    }
}
