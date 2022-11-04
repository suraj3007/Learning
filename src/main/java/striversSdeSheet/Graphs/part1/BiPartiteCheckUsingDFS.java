package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteCheckUsingDFS {

    public static boolean isGraphBipartite(ArrayList<ArrayList<Integer>> edges) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            for (int j = 0; j < edges.size(); j++) {
                if (edges.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] color = new int[edges.size()];
        Arrays.fill(color, -1);
        /*for (int i = 0; i < edges.size(); i++) {
            color[i] = -1;
        }*/

        for (int i = 0; i < edges.size(); i++) {
            if (color[i] == -1 && (!checkDfs(i, adjList, color, 0))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] color, int currentColor) {
        color[node] = 1 - currentColor;
        for (Integer adjNode : adjList.get(node)) {
            if (color[adjNode] == -1) {
                if (!checkDfs(adjNode, adjList, color, color[node])) {
                    return false;
                }
            } else if (color[adjNode] == color[node]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
