package main.java.striversSdeSheet.Graphs.part1;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsInEightDirections {
    static class Pair{
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void bfs(int ro, int co, char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        grid[ro][co] = '0';
        queue.offer(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.first;
            int col = pair.second;

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nrow = row + delRow;
                    int mcol = col + delCol;

                    if (nrow >= 0 && nrow < n && mcol >= 0 && mcol < m && grid[nrow][mcol] == '1') {
                        grid[nrow][mcol] = '0';
                        queue.offer(new Pair(nrow, mcol));
                    }
                }
            }
        }
    }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
