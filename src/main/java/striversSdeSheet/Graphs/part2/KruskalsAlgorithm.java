package main.java.striversSdeSheet.Graphs.part2;

import java.util.*;

public class KruskalsAlgorithm {

    static class Node {
        int u, v, weight;
        Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        public int getU() { return this.u; }
        public int getV() { return this.v; }
        public int getWeight() { return this.weight; }
    }

    private static int findParent(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public static int kruskalMST(int n, int m, List<List<Integer>> graph) {
        // Write your code here.
        ArrayList<Node> nodes = new ArrayList<>();

        for (List<Integer> edge : graph) {
            nodes.add(new Node(edge.get(0), edge.get(1), edge.get(2)));
            nodes.add(new Node(edge.get(1), edge.get(0), edge.get(2)));
        }

        nodes.sort(Comparator.comparingInt(Node::getWeight));
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int costOfMst = 0;

        for (Node node : nodes) {
            if (findParent(node.getU(), parent) != findParent(node.getV(), parent)) {
                costOfMst += node.getWeight();
                union(node.getU(), node.getV(), parent, rank);
            }
        }

        return costOfMst;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(Arrays.asList(1, 2, 6));
        graph.add(Arrays.asList(2, 3, 5));
        graph.add(Arrays.asList(3, 4, 4));
        graph.add(Arrays.asList(1, 4, 1));
        graph.add(Arrays.asList(1, 3, 2));
        graph.add(Arrays.asList(3, 5, 3));

        System.out.println(kruskalMST(5, 6, graph));
    }
}
