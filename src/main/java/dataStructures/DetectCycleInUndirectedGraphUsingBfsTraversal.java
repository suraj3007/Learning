package main.java.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraphUsingBfsTraversal {

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

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adjList, int noOfVertices){
        boolean[] visited = new boolean[noOfVertices];
        //For multiple components
        for (int i = 0; i < noOfVertices; i++) {
            if(!visited[i] && checkCycle(adjList, i, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int noOfVertices = 12;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < noOfVertices; i++) {
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
        /*adjacencyList.get(7).add(8);
        adjacencyList.get(8).add(7);*/
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
