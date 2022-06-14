package main.java.dataStructures.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {

    static class Pair{
        int v, weight;

        public Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    private static void topologicalSort(ArrayList<ArrayList<Pair>> adj, int vertex,
                                        boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for(Pair p : adj.get(vertex)) {
            if(!visited[p.getV()]) {
                topologicalSort(adj, p.getV(), visited, stack);
            }
        }
        stack.push(vertex);
    }

    private static void shortestPath(ArrayList<ArrayList<Pair>> adj, int noOfVertices, int src) {
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[noOfVertices];
        boolean[] visited = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < noOfVertices; i++) {
            if(!visited[i]) {
                topologicalSort(adj, i, visited, stack);
            }
        }

        dist[src] = 0;
        while (!stack.empty()) {
            int node = stack.pop();
            //If node has been reached previously. Since it is a directed graph, before calculating
            //distance of adjacent nodes, we have to reach that source node.
            //Hence it's distance should be non-infinity.
            //without reaching source node, you cannot traverse to adjacent node because of directed graph.
            if(dist[node] != Integer.MAX_VALUE) {
                for (Pair p : adj.get(node)) {
                    if (dist[node] + p.getWeight() < dist[p.getV()]) {
                        dist[p.getV()] = dist[node] + p.getWeight();
                    }
                }
            }
        }

        for (int i = 0; i < noOfVertices; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex "+ i + " is unreachable");
            } else {
                System.out.println("Shortest distance of vertex " + i + " from source " + src
                        + " is " +dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < noOfVertices; i++) {
            adj.add(i, new ArrayList<>());
        }

        adj.get(0).add(new Pair(1,2));
        adj.get(0).add(new Pair(4,1));
        adj.get(1).add(new Pair(2,3));
        adj.get(2).add(new Pair(3,6));
        adj.get(4).add(new Pair(2,2));
        adj.get(4).add(new Pair(5,4));
        adj.get(5).add(new Pair(3,1));

        shortestPath(adj, noOfVertices, 0);
    }
}
