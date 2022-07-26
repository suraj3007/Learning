package main.java.striversSdeSheet.StackAndQueue.part2;

import java.util.Queue;
import java.util.LinkedList;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowLength = grid.length;
        int colLength = grid[0].length;
        int orangeCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] != 0) {
                    orangeCount++;
                }
            }
        }

        if (orangeCount == 0) return 0;

        int minTime = 0, rottenCount = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int size = queue.size();
            rottenCount += size;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rowLength || y >= colLength ||
                            grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }

            if (queue.size() != 0) {
                minTime++;
            }
        }

        return rottenCount == orangeCount ? minTime : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
