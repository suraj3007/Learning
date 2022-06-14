package main.java.dataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteGraphUsingBFS {

    private static final int noOfVertices = 7;

    private static boolean checkBfs(ArrayList<ArrayList<Integer>> adj, int[] color, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : adj.get(current)) {
                if (color[i] == -1) {
                    color[i] = 1 - color[current];
                    queue.add(i);
                } else if (color[i] == color[current]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBipartiteGraph(ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < noOfVertices; i++) {
            if (color[i] == -1 && !checkBfs(adj, color, i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++) {
            adj.add(i, new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);

        System.out.println(isBipartiteGraph(adj) ?
                "Bipartite Graph" :
                "Not a Bipartite Graph");
    }
}
