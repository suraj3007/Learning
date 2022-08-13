package main.java.striversSdeSheet.Graphs.part2;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {

    static class Node {
        int u, v, weight;

        Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getU() { return u; }
        public int getV() { return v; }
        public int getWeight() { return weight; }
    }

    static int bellmanFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<Node> nodesList = new ArrayList<>();
        for (ArrayList<Integer> edge : edges) {
            nodesList.add(new Node(edge.get(0), edge.get(1), edge.get(2)));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1000000000);

        dist[src] = 0;
        //Relax edges for n - 1 times
        for (int i = 1; i <= n - 1; i++) {
            for (Node node : nodesList) {
                if (dist[node.getU()] != 1e9 && dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }
        }

        int fl = 0;
        for (Node node : nodesList) {
            if (dist[node.getU()] != 1e9 && dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                fl = 1;
                dist[node.getV()] = dist[node.getU()] + node.getWeight();
                break;
            }
        }

        if (fl == 1) return 1000000000;
        return dist[dest];
    }

    public static void main(String[] args) {

    }
}
