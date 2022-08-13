package main.java.striversSdeSheet.Graphs.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    static class Node {
        int v, weight;
        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() { return v; }
        public int getWeight() { return weight; }

    }

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Write your code here.
        //since nodes are labeled from 1 to N
        int[] key = new int[n + 1];  //Stores the weight of vertices
        int[] parent = new int[n + 1]; //Maintains Parent of vertices for final MST
        boolean[] mst = new boolean[n + 1]; //Vertices considered for MST

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        ArrayList<ArrayList<Node>> nodesList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodesList.add(new ArrayList<>());
        }

        //creating adjacency list from given inputs
        for (ArrayList<Integer> edge : g) {
            nodesList.get(edge.get(0)).add(new Node(edge.get(1), edge.get(2)));
            nodesList.get(edge.get(1)).add(new Node(edge.get(0), edge.get(2)));
        }

        //Passing the comparator so that minimum weight element will be at top always.
        //This will give the minimum weight value in O(log n)
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        key[1] = 0;
        queue.add(new Node(1, key[1]));

        while(!queue.isEmpty()) {
            //Gives minimum weight element from the top
            int u = queue.poll().getV();
            //Mark it as considered for MST
            mst[u] = true;

            //Check for adjacent node who is not considered for MST and
            // whose weight is lesser than already available in key array for that vertex
            for (Node node : nodesList.get(u)) {
                if (!mst[node.getV()] && node.getWeight() < key[node.getV()]) {
                    key[node.getV()] = node.getWeight();
                    //Mark the parent for this adjacent node
                    parent[node.getV()] = u;
                    //add the adjacent node with new lesser weight.
                    queue.add(new Node(node.getV(), key[node.getV()]));
                }
            }
        }

        //Adding into resultant list. It should be u -> v -> w (minimum weight)
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {  //Because 1 is source so, it won't have any parent.
            ArrayList<Integer> ds = new ArrayList<>();
            ds.add(parent[i]);
            ds.add(i);
            ds.add(key[i]);
            res.add(ds);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
