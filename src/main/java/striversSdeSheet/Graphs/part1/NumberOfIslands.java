package main.java.striversSdeSheet.Graphs.part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    private static void dfs(int vertex, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[vertex] = true;
        for (int node : adjList.get(vertex)) {
            if (!visited[node]) {
                dfs(node, adjList, visited);
            }
        }
    }

    //GFG
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {
    }

    //Leetcode
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs (char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        bfs(grid, i - 1, j);    //up
        bfs(grid, i + 1, j);    //down
        bfs(grid, i, j - 1);    //left
        bfs(grid, i, j + 1);    //right
    }

    private void bfs2 (char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int k = 0;  k < 4; k++) {
                int x = point[0] + dx[k];
                int y = point[1] + dy[k];

                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    queue.offer(new int[]{x, y});
                }

            }
        }
    }
}
