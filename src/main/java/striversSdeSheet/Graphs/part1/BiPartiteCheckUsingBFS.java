package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteCheckUsingBFS {

    public static boolean isGraphBipartite(ArrayList<ArrayList<Integer>> edges) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            adjList.add(new ArrayList<>());
        }

        //Converting adj matrix into adj list
        for (int i = 0; i < edges.size(); i++) {
            for (int j = 0; j < edges.size(); j++) {
                if (edges.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] color = new int[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            color[i] = -1;
        }

        for (int i = 0; i < edges.size(); i++) {
            if (color[i] == -1 && (!checkBfs(i, adjList, color))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkBfs(int vertex, ArrayList<ArrayList<Integer>> adjList, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        color[vertex] = 1;
        queue.add(vertex);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer adjNode : adjList.get(node)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = 1 - color[node];
                    queue.add(adjNode);
                } else if (color[node] == color[adjNode]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
