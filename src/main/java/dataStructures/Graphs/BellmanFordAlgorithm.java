package main.java.dataStructures.Graphs;

import java.util.ArrayList;

//Dijikstra algorithm doesn't work for negative weighted graphs.
//Bellman ford overcomes this problem to work with negative weighted edges.
//It will not work only in case of negative weighted cycle. However, it also help to detect negative weighted cycle.
//We have to relax all the edges by N - 1 times. After relaxing N - 1 times, distance will have the shortest path.
//formula: - if d(u) + (weight to reach to v) < d(v) then d(v) = d(u) + (weight to reach to v)
//However, if one more iteration further reduces the weight of edges it means that graph contains negative weighted cycle.
//Reason for N - 1 relaxation: - because that is the longest path, graph can have to reach from src to farthest node.
//for eg: 1 -> 2 -> 3 -> 4 -> 5 : - longest path to reach from 1 to 5 contains exactly N - 1 edges.
public class BellmanFordAlgorithm {

    static int noOfVertices = 6;

    static class Node {
        int u, v, weight;

        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getU() {
            return u;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    private static void bellmanFord(ArrayList<Node> adjList, int src) {
        int[] dist = new int[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            dist[i] = 1000000;
        }

        dist[src] = 0;
        //relaxing N - 1 times
        for (int i = 0; i < noOfVertices - 1; i++) {
            for (Node node : adjList) {
                if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }
        }

        boolean cycleDetectedFlag = false;
        //Further one more iteration to detect if graph contains negative weighted cycle.
        for (Node node : adjList) {
            if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                cycleDetectedFlag = true;
                System.out.println("Cycle detected..!");
                break;
            }
        }

        if (!cycleDetectedFlag) {
            for (int i = 0; i < noOfVertices; i++) {
                System.out.println("Shortest distance of vertex " + i + " from source " + src
                        + " is " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> adjList = new ArrayList<>();

        adjList.add(new Node(3, 2, 6));
        adjList.add(new Node(5, 3, 1));
        adjList.add(new Node(0, 1, 5));
        adjList.add(new Node(1, 5, -3));
        adjList.add(new Node(1, 2, -2));
        adjList.add(new Node(3, 4, -2));
        adjList.add(new Node(2, 4, 3));

        bellmanFord(adjList, 0);
    }
}
