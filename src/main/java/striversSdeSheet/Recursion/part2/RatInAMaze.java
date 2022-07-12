package main.java.striversSdeSheet.Recursion.part2;

import java.util.ArrayList;

public class RatInAMaze {

    public static void solve(int i, int j, int[][] m, int n, String move,
                             int[][] vis, int[] di, int[] dj, ArrayList<String> ans) {

        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n
                    && vis[nexti][nextj] == 0 && m[nexti][nextj] == 1) {
                vis[i][j] = 1;
                solve(nexti, nextj, m, n, move + dir.charAt(ind), vis, di, dj, ans);
                vis[i][j] = 0;
            }
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] vis = new int[n][n];
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};

        ArrayList<String> ans = new ArrayList<>();

        if (m[0][0] == 1) {
            solve(0, 0, m, n, "", vis, di, dj, ans);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
