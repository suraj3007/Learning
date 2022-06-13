package main.java.dataStructures;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraphUsingDfsTraversal {

    private static boolean checkCycle(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int vertex, int parent) {

        visited[vertex] = true;
        for(int i : adjList.get(vertex)) {
            if (!visited[i]) {
                if (checkCycle(adjList, visited, i, vertex))
                    return true;
            } else if (parent != i) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adjList, int noOfVertices) {

        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i] && checkCycle(adjList, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int noOfVertices = 12;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        //first component
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);
        adjacencyList.get(2).add(4);

        //second component
        adjacencyList.get(3).add(5);
        adjacencyList.get(5).add(3);
        adjacencyList.get(5).add(10);
        adjacencyList.get(5).add(6);
        adjacencyList.get(6).add(5);
        adjacencyList.get(6).add(7);
        adjacencyList.get(7).add(6);
        adjacencyList.get(7).add(8);
        adjacencyList.get(8).add(7);
        adjacencyList.get(8).add(9);
        adjacencyList.get(8).add(11);
        adjacencyList.get(9).add(10);
        adjacencyList.get(9).add(8);
        adjacencyList.get(10).add(5);
        adjacencyList.get(10).add(9);
        adjacencyList.get(11).add(8);

        System.out.println(isCycle(adjacencyList, noOfVertices) ?
                "Graph contains a cycle" :
                "Graph does not contain a cycle");
    }
}
