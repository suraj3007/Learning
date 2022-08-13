package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraphUsingDfs {

    private static boolean checkCycle(int vertex, int parent, ArrayList<ArrayList<Integer>> adjList,
                                      boolean[] visited) {
        visited[vertex] = true;
        for (int node : adjList.get(vertex)) {
            if (!visited[node]) {
                if (checkCycle(node, vertex, adjList, visited))
                    return true;
            } else if (parent != node) {
                return true;
            }
        }

        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && checkCycle(i, -1, adjList, visited)) {
                return "Yes";
            }
        }
        return "No";
    }

    public static void main(String[] args) {

    }
}
