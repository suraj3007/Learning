package main.java.striversSdeSheet.Graphs.part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Node implements Comparator<Node> {

        int v, weight;
        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        Node() {}

        public int getV() { return this.v; }
        public int getWeight() { return this.weight; }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.weight < node2.weight)
                return -1;
            else if (node1.weight > node2.weight)
                return 1;
            return 0;
        }
    }

    public static ArrayList< Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
        // Write your code here.
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            adjList.get(vec.get(i).get(0)).add(new Node(vec.get(i).get(1), vec.get(i).get(2)));
            adjList.get(vec.get(i).get(1)).add(new Node(vec.get(i).get(0), vec.get(i).get(2)));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(vertices, new Node());
        int[] dist = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        queue.add(new Node(source, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node it : adjList.get(node.getV())) {
                if (node.getWeight() + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = node.getWeight() + it.getWeight();
                    queue.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            res.add(dist[i]);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
