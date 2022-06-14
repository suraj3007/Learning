package main.java.dataStructures.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * It follows Disjoint set algorithm along with Path compression.
 * findParent() and union() are operation performed in Disjoint set algorithm
 * Application of Disjoint set algorithm :
 * 1. Kruskal's algorithm 2. Finding if both nodes belong to same component or not.
 */
public class KruskalsAlgorithmForMST {

    static int noOfVertices = 5;
    static int[] parent = new int[noOfVertices];
    static int[] rank = new int[noOfVertices];
    static int costOfMST = 0;
    static ArrayList<Node> mstPath = new ArrayList();

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

    private static int findParent(int node) {

        if(node == parent[node]) {
            return node;
        }
        //Path compression. 7 -> 6 -> 2 -> 4
        //If found out once that parent of 7 is 4 so just update it in array.
        //So that, next time when we have to find parent of 7, we don't have to repeat same iteration of 6 -> 2 ->4 again.
        //It will directly go to 4 and check parent of 4 is 4 then will return 4 so saved 2 iteration.
        return parent[node] = findParent(parent[node]);
    }

    private static void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        //attach the lower rank node to higher rank node so that height of tree doesn't increase
        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            //in case of similar rank, we can attach any node to anyone. parent[u] = v; is also correct
            parent[v] = u;
            //in case of similar rank of PARENT, increase the rank of node with whom we are attaching the node.
            //Here, we are attaching v with u. So, parent of v is u now. Hence, incrementing rank of u.
            rank[u]++;
        }
    }

    //Declaring parent vertex of each vertex as itself initially. For eg 1 -> 1, 2 -> 2, 3 -> 3 etc..
    //Declaring initial rank as 0 for all vertices.
    private static void makeSet() {
        for(int i = 0; i < noOfVertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private static void kruskalsAlgo(ArrayList<Node> adj) {
        //Sorting the edges in ascending order of their weight.
        Collections.sort(adj, new NodeComparator());

        for (Node it : adj) {
            //if parent of both edges will be different then, cycle will not be formed.
            if (findParent(it.getU()) != findParent(it.getV())) {
                costOfMST += it.getWeight();
                mstPath.add(it);
                union(it.getU(), it.getV());
            }
        }

        System.out.println("Cost of MST: " +costOfMST);
        for(Node n : mstPath) {
            System.out.println(n.getU() + " " + n.getV());
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> adj = new ArrayList<>();

        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));

        makeSet();
        kruskalsAlgo(adj);
    }
}

class NodeComparator implements Comparator<KruskalsAlgorithmForMST.Node> {

    @Override
    public int compare(KruskalsAlgorithmForMST.Node node1, KruskalsAlgorithmForMST.Node node2) {
        if (node1.getWeight() < node2.getWeight()) {
            return -1;
        } else if (node1.getWeight() > node2.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}