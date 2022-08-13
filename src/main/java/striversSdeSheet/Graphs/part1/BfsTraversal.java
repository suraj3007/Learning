package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsTraversal {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            res.add(node);

            for (Integer it : adj.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
    }

    //CodingNinja solution

    static ArrayList<Integer> result = new ArrayList<>();

    public static void printBFSHelper(int[][] edges, int source, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);

        // Traversing all the nodes that are connected to the source node.
        while (!queue.isEmpty()) {
            int front = queue.remove();
            result.add(front);
            for (int i = 0; i < edges.length; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // Converts the given input into adjacency matrix.
    public static int[][] createAdjMat(int vertex, int[][] edges) {

        int[][] adjacency_matrix = new int[vertex][vertex];

        for (int i = 0; i < edges[0].length; i++) {
            adjacency_matrix[edges[0][i]][edges[1][i]] = 1;
            adjacency_matrix[edges[1][i]][edges[0][i]] = 1;
        }

        return adjacency_matrix;
    }

    public static ArrayList<Integer> BFS(int vertex, int[][] edges) {

        int[][] adjacency_matrix = createAdjMat(vertex, edges);
        boolean[] visited = new boolean[adjacency_matrix.length];

        // Traversing through all the nodes.
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                printBFSHelper(adjacency_matrix, i, visited);
            }
        }

        return result;
    }
}
