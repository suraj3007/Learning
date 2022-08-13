package main.java.striversSdeSheet.Graphs.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithmForSCC {

    private static void topoUsingDfs(int vertex, ArrayList<ArrayList<Integer>> adjList, int[] visited, Stack<Integer> stack) {
        visited[vertex] = 1;
        for (int adjNode : adjList.get(vertex)) {
            if (visited[adjNode] == 0) {
                topoUsingDfs(adjNode, adjList, visited, stack);
            }
        }
        stack.push(vertex);
    }

    private static void revDfs(int vertex, ArrayList<ArrayList<Integer>> transpose, int[] visited, ArrayList<Integer> ds) {
        ds.add(vertex);
        visited[vertex] = 1;
        for (int adjNode : transpose.get(vertex)) {
            if (visited[adjNode] == 0) {
                revDfs(adjNode, transpose, visited, ds);
            }
        }
    }

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        //step 1 : find vertex in order of their finishing time
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                topoUsingDfs(i, adjList, visited, stack);
            }
        }

        //step 2: Find transpose.
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transpose.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            visited[i] = 0;
            for (int it : adjList.get(i)) {
                transpose.get(it).add(i);
            }
        }

        //step 3: Find dfs for vertices arranged in order of their finishing time
        List<List<Integer>> res = new ArrayList<>();
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node] == 0) {
                ArrayList<Integer> ds = new ArrayList<>();
                revDfs(node, transpose, visited, ds);
                res.add(ds);
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
