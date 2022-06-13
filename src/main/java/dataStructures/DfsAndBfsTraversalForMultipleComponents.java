package main.java.dataStructures;

import java.util.LinkedList;

public class DfsAndBfsTraversalForMultipleComponents {

    private static int noOfVertices;
    private static LinkedList<Integer> adjacencyList[];

    DfsAndBfsTraversalForMultipleComponents(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjacencyList = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    private void addEdge(int startVertex, int newVertex) {
        adjacencyList[startVertex].add(newVertex);
    }

    private void bfsUtil() {

        System.out.println("\nBFS traversal: ");
        boolean[] visited = new boolean[noOfVertices];
        int noOfComponents = 0;
        //In case of disconnected graphs we have to visit all vertices one to one. Hence, looping is required.
        //For connected graph, looping is not required. directly call dfsTraversalUsingRecursion(vertex, visited);
        for (int i = 0; i < noOfVertices; i++) {
            if(!visited[i]) {
                noOfComponents++;
                bfsTraversal(i, visited);
            }
        }
        System.out.println("\nNo. of connected Components: " +noOfComponents);
    }

    private void bfsTraversal(int vertex, boolean[] visitedVertex) {

        LinkedList<Integer> queue = new LinkedList<>();

        visitedVertex[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Integer adjacentVertex : adjacencyList[vertex]) {
                if (!visitedVertex[adjacentVertex]) {
                    visitedVertex[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
            }
        }
    }


    private void dfsUtil() {

        System.out.println("\nDFS traversal: ");
        boolean[] visited = new boolean[noOfVertices];
        int noOfComponents = 0;

        //In case of disconnected graphs we have to visit all vertices one to one. Hence, looping is required.
        //For connected graph, looping is not required. directly call dfsTraversalUsingRecursion(vertex, visited);
        for (int i = 0; i < noOfVertices; i++) {
            if(!visited[i]) {
                noOfComponents++;
                dfsTraversalUsingRecursion(i, visited);
            }
        }
        System.out.println("\nNo. of connected Components: " +noOfComponents);
    }

    private void dfsTraversalUsingRecursion(Integer vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int adjVertex : adjacencyList[vertex]) {
            if(!visited[adjVertex]) {
                dfsTraversalUsingRecursion(adjVertex, visited);
            }
        }
    }

    public static void main(String[] args) {
        DfsAndBfsTraversalForMultipleComponents graph = new DfsAndBfsTraversalForMultipleComponents(9);

        /*graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);*/

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(1, 6);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);
        graph.addEdge(4, 6);
        graph.addEdge(4, 3);
        graph.addEdge(5, 1);
        graph.addEdge(5, 2);
        graph.addEdge(6, 1);
        graph.addEdge(6, 4);
        graph.addEdge(7, 8);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        graph.bfsUtil();
        System.out.println();
        graph.dfsUtil();
    }
}
