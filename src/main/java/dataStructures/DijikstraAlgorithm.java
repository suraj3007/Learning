package main.java.dataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijikstraAlgorithm {

    static int noOfVertices = 5;

    static class Node implements Comparator<Node> {
        int v, weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public Node() {
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.getWeight() < node2.getWeight()) {
                return -1;
            } else if (node1.getWeight() > node2.getWeight()) {
                return 1;
            }
            return 0;
        }
    }

    private static void shortestPath (ArrayList<ArrayList<Node>> adj, int[] dist, int src) {
        // It will arrange the element in ascending order of their weight
        PriorityQueue<Node> queue = new PriorityQueue<>(noOfVertices, new Node());
        dist[src] = 0;
        queue.add(new Node(src, dist[src]));

        while (!queue.isEmpty()) {
            int current = queue.poll().getV();
            for (Node adjNode : adj.get(current)) {
                if(dist[current] + adjNode.getWeight() < dist[adjNode.getV()]) {
                    dist[adjNode.getV()] = dist[current] + adjNode.getWeight();
                    queue.add(new Node(adjNode.getV(), dist[adjNode.getV()]));
                }
            }
        }

        for (int i = 0; i < noOfVertices; i++) {
            System.out.println("Shortest distance of vertex " + i + " from source " + src
                    + " is " + dist[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        int[] dist = new int[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            adj.add(i, new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        adj.get(0).add(new Node(1,2));
        adj.get(1).add(new Node(0,2));

        adj.get(1).add(new Node(2,4));
        adj.get(2).add(new Node(1,4));

        adj.get(0).add(new Node(3,1));
        adj.get(3).add(new Node(0,1));

        adj.get(3).add(new Node(2,3));
        adj.get(2).add(new Node(3,3));

        adj.get(1).add(new Node(4,5));
        adj.get(4).add(new Node(1,5));

        adj.get(2).add(new Node(4,1));
        adj.get(4).add(new Node(2,1));

        shortestPath(adj, dist, 0);
    }
}
