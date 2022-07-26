package main.java.striversSdeSheet.BinaryTrees.part1;

import main.java.striversSdeSheet.BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePathInBinaryTree {

    private boolean findPath(TreeNode A, int B, List<Integer> ds) {
        if (A == null) return false;

        ds.add(A.val);
        if (A.val == B) return true;

        if (findPath(A.left, B, ds) || findPath(A.right, B, ds)) return true;

        ds.remove(ds.size() - 1);
        return false;
    }

    public int[] solve(TreeNode A, int B) {
        List<Integer> ds = new ArrayList<>();
        findPath(A, B, ds);
        return ds.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
