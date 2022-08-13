package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInUndirectedGraphUsingBFS {

    static class Node {
        int vertex, parent;
        Node(int vertex, int parent) {
            this.vertex = vertex;
            this.parent = parent;
        }
    }

    private static boolean checkCycle(ArrayList<ArrayList<Integer>> adjList, int vertex, boolean[] visited) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(vertex, -1));
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int current = queue.peek().vertex;
            int parent = queue.peek().parent;
            queue.poll();

            for(Integer i : adjList.get(current)) {
                if(!visited[i]) {
                    queue.add(new Node(i, current));
                    visited[i] = true;
                } else if (parent != i) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList< Integer >> adjList = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n + 1];
        //For multiple components
        for (int i = 1; i <= n; i++) {
            if(!visited[i] && checkCycle(adjList, i, visited)) {
                return "Yes";
            }
        }
        return "No";
    }

    public static void main(String[] args) {

    }
}
