package main.java.dataStructures.Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//Prims algorithm is explained in detail in notebook.
public class PrimsAlgorithmForMST {

    static int noOfVertices = 5;

    private static void primsAlgo (ArrayList<ArrayList<Node>> adj) {
        int[] key = new int[noOfVertices]; //Stores the weight of vertices
        int[] parent = new int[noOfVertices]; //Maintains Parent of vertices for final MST
        boolean mstSet[] = new boolean[noOfVertices]; //Vertices considered for MST

        for(int i = 0; i < noOfVertices; i++) {
            key[i] = Integer.MAX_VALUE; //Initialize it with max value
            parent[i] = -1;
        }

        //Passing the comparator so that minimum weight element will be at top always.
        //This will give the minimum weight value in O(log n)
        PriorityQueue<Node> queue = new PriorityQueue<>(noOfVertices, new Node());

        key[0] = 0; //Initialize vertex 0 with 0 weight.
        queue.add(new Node(0, key[0]));

        for (int i = 0; i < noOfVertices - 1; i++) {
            //Gives minimum weight element from the top
            int u = queue.poll().getV();
            //Mark it as considered for MST
            mstSet[u] = true;

            //Check for adjacent node who is not considered for MST and
            // whose weight is lesser than already available in key array for that vertex
            for (Node it : adj.get(u)) {
                if (!mstSet[it.getV()] && it.getWeight() < key[it.getV()]) {
                    key[it.getV()] = it.getWeight();
                    //Mark the parent for this adjacent node
                    parent[it.getV()] = u;
                    //add the adjacent node with new lesser weight.
                    queue.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }

        for (int i = 1; i < noOfVertices; i++) {
            System.out.println(parent[i] + "-" + i);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i < noOfVertices; i++) {
            adj.add(new ArrayList<Node>());
        }

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        primsAlgo(adj);
    }
}

class Node implements Comparator<Node> {
    int v;
    int weight;

    public Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    public Node() {}

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if(node1.getWeight() < node2.getWeight()) {
            return -1;
        } else if (node1.getWeight() > node2.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
