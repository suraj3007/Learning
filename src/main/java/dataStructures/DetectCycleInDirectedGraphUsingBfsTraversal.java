package main.java.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Apply Kahn's algorithm. Only change : find node count after topo sort and compare it with noOfVertices.
// If count is not same then graph contains a cycle. Bcoz Topological sort is DAG(directed acyclic graph).
//If graph will contain a cycle then it wont be able to have all nodes after topo sort.
//Its a hack we are using here. In interview prefer DFS approach for finding cycle in directed graph.
public class DetectCycleInDirectedGraphUsingBfsTraversal {

    private static boolean isCyclic(ArrayList<ArrayList<Integer>> adjList, int noOfVertices) {
        int[] inDegree = new int[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        //Calculating the in-degree
        for(int i = 0; i < noOfVertices; i++) {
            for (int j : adjList.get(i)) {
                inDegree[j]++;
            }
        }

        for(int i = 0; i < noOfVertices; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int nodesCount = 0;
        while (!queue.isEmpty()) {
            nodesCount++;
            int vertex = queue.poll();
            for (int i : adjList.get(vertex)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return nodesCount != noOfVertices ? true : false;
    }

    public static void main(String[] args) {
        int noOfVertices = 6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < noOfVertices; i++) {
            adjList.add(i, new ArrayList<>());
        }

        //Sample for no cycle
        /*adjList.get(2).add(3);
        adjList.get(3).add(1);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(5).add(0);
        adjList.get(5).add(2);*/

        //Sample for Cycle
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(4).add(2);

        System.out.println(isCyclic(adjList, noOfVertices) ?
                "Graph contains a cycle" :
                "Graph does not contain a cycle");;
    }
}
