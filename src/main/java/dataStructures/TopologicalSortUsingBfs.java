package main.java.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Kahn's algorithm -> Store in-degree of edges in an array and start with vertex which has 0 in-degree.
public class TopologicalSortUsingBfs {

    private static void topologicalSortUsingBfs(ArrayList<ArrayList<Integer>> adjList, int noOfVertices) {
        int[] inDegree = new int[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        //Calculating in-degree
        for(int i = 0; i < noOfVertices; i++) {
            for (int j : adjList.get(i)) {
                inDegree[j]++;
            }
        }

        //adding value in queue which has 0 in-degree
        for (int i = 0; i < noOfVertices; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //Applying BFS
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int i : adjList.get(vertex)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < noOfVertices; i++) {
            adjList.add(i, new ArrayList<>());
        }

        adjList.get(2).add(3);
        adjList.get(3).add(1);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(5).add(0);
        adjList.get(5).add(2);

        topologicalSortUsingBfs(adjList, noOfVertices);
    }
}
