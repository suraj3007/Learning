package main.java.striversSdeSheet.BinarySearchTree.part1;

import main.java.striversSdeSheet.BinaryTrees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersOfTree {

    public Node connect(Node root) {

        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node rightNode = null;
            for(int i = q.size(); i > 0; i--) {
                Node curr = q.poll();
                curr.next = rightNode;
                rightNode = curr;
                if(curr.right != null) {
                    //Since we want address of right to store into previous node,
                    // hence we are storing value right node first & then left node.
                    q.offer(curr.right);
                    q.offer(curr.left);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
