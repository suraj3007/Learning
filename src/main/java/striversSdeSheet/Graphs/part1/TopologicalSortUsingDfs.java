package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingDfs {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                findTopo(i, adj, visited, stack);
            }
        }

        int[] topo = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            topo[index++] = stack.pop();
        }
        return topo;
    }

    private static void findTopo(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int node : adj.get(vertex)) {
            if (!visited[node]) {
                findTopo(node, adj, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {

    }
}
