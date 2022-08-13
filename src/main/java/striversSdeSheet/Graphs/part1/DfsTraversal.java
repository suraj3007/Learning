package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;

public class DfsTraversal {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];

        //For multiple components
        for (int  i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, res);
            }
        }

        return res;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
        res.add(node);
        visited[node] = true;

        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, adj, visited, res);
            }
        }
    }

    public static void main(String[] args) {

    }
}
