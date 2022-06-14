package main.java.dataStructures.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Unit weight - each vertex has weight 1 to reach to other vertex.
public class ShortestPathInUndirectedGraph {

    private static void shortestPathFromSource(ArrayList<ArrayList<Integer>> adj, int noOfVertices,
                                                   int src) {
        int[] distance = new int[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < noOfVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        queue.add(src);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int adjNode : adj.get(node)) {
                if (distance[node] + 1 < distance[adjNode]) {
                    distance[adjNode] = distance[node] + 1;
                    queue.add(adjNode);
                }
            }
        }

        for (int i = 0; i < noOfVertices; i++) {
            System.out.println("Shortest distance of vertex " + i + " from source " + src
            + " is " +distance[i]);
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++) {
            adj.add(i, new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(6);
        adj.get(3).add(0);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(8);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(8).add(6);
        adj.get(8).add(7);

        shortestPathFromSource(adj, noOfVertices, 2);
    }
}
