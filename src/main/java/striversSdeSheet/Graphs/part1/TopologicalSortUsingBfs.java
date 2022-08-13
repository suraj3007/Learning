package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TopologicalSortUsingBfs {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] topo = new int[V];
        int[] inDegree = new int[V];
        //Calculate in-degree
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        //push vertex whose in-degree is 0
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            topo[index++] = vertex;
            for (int it : adj.get(vertex)) {
                //reduce in-degree for adj nodes and check if 0 then add it into queue.
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    queue.add(it);
                }
            }

        }
        return topo;
    }

    public static void main(String[] args) {

    }
}
