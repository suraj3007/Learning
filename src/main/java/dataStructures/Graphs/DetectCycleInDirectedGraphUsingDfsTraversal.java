package main.java.dataStructures.Graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphUsingDfsTraversal {

    private static boolean checkCycle(ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
                                      boolean[] dfsVisited, int vertex) {

        visited[vertex] = dfsVisited[vertex] = true;

        for (int i : adjList.get(vertex)) {
            if (!visited[i]) {
                if (checkCycle(adjList, visited, dfsVisited, i))
                    return true;
            } else if (dfsVisited[i]) {
                return true;
            }
        }

        dfsVisited[vertex] = false;
        return false;
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adjList, int noOfVertices) {

        boolean[] visited = new boolean[noOfVertices];
        boolean[] dfsVisited = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i] && checkCycle(adjList, visited, dfsVisited, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int noOfVertices = 10;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++){
            adjacencyList.add(i, new ArrayList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(4);
        adjacencyList.get(3).add(6);
        adjacencyList.get(4).add(5);
        adjacencyList.get(6).add(5);
        adjacencyList.get(7).add(2);
        adjacencyList.get(7).add(8);
        adjacencyList.get(8).add(9);
        adjacencyList.get(9).add(7);

        System.out.println(isCycle(adjacencyList, noOfVertices) ?
                "Graph contains a cycle" :
                "Graph does not contain a cycle");
    }
}
