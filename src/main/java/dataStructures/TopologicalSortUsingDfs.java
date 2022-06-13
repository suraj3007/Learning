package main.java.dataStructures;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingDfs {

     public static void topologicalSortUsingDfs(ArrayList<ArrayList<Integer>> adjList, int vertex,
                                        boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for(int current : adjList.get(vertex)) {
            if (!visited[current]) {
                topologicalSortUsingDfs(adjList, current, visited, stack);
            }
        }
        stack.push(vertex);
    }

    private static void topologicalUtil(ArrayList<ArrayList<Integer>> adjList, int noOfVertices) {
        boolean[] visited = new boolean[noOfVertices];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < noOfVertices; i++) {
            if(!visited[i]) {
                topologicalSortUsingDfs(adjList, i, visited, stack);
            }
        }

        System.out.println("Topological Sort : ");
        while (!stack.empty()){
            System.out.print(stack.pop() + " ");
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

        topologicalUtil(adjList, noOfVertices);
    }
}
