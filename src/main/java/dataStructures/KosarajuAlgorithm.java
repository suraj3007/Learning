package main.java.dataStructures;

import java.util.ArrayList;
import java.util.Stack;

//This algorithm is used to identify strongly connected components.
//SCC -> Each node will get visited if you start from any node within that component.
//for eg if graph consist of edges: 1 -> 2 -> 3 -> 1 && 2 -> 4 -> 5
//SCC will be :- 1 2 3
//SCC: - 4 (bcoz of non cyclic)
//SCC: - 5 (bcoz of non cyclic)
public class KosarajuAlgorithm {

    static int noOfVertices = 5;

    private static void topoSortUsingDfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack,
                                         boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int adjacent : adj.get(vertex)) {
            if (!visited[adjacent]) {
                topoSortUsingDfs(adj, stack, visited, adjacent);
            }
        }
        stack.push(vertex);
    }

    private static void revDfs (ArrayList<ArrayList<Integer>> transpose, boolean[] visited, int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int adjacent : transpose.get(vertex)) {
            if (!visited[adjacent]) {
                revDfs(transpose, visited, adjacent);
            }
        }
    }

    //It consist of 3 steps.
    private static void kosarajuAlgo (ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[noOfVertices];

        //Step 1: sort all nodes in order of their finishing time -> Topological sort
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                topoSortUsingDfs(adj, stack, visited, i);
            }
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();

        for (int i = 0; i < noOfVertices; i++) {
            transpose.add(i, new ArrayList<>());
        }

        //Step 2: Reversing the edge direction
        for (int i = 0; i < noOfVertices; i++) {
            visited[i] = false;
            for (int node : adj.get(i)) {
                transpose.get(node).add(i);
            }
        }

        //Step 3: Do the DFS according to the finishing time
        while (!stack.empty()) {
            int topElement = stack.pop();
            if (!visited[topElement]) {
                System.out.print("SCC: ");
                revDfs(transpose, visited, topElement);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++) {
            adj.add(i, new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);

        kosarajuAlgo(adj);
    }
}
