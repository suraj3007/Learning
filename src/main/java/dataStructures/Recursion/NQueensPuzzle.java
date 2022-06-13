package main.java.dataStructures.Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Check for left diagonal: - row
// Check for lower diagonal: - row + column
// Check for upper diagonal: - (n - 1) + (column - row)
public class NQueensPuzzle {

    private static List<String> construct(char[][] board) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }

    private static void solve(int col, char[][] board, int[] leftRow, int[] lowerDiagonal,
                                            int[] upperDiagonal, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 &&
            upperDiagonal[(board.length - 1) + (col - row)] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[(board.length - 1) + (col - row)] = 1;
                solve(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, res);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[(board.length - 1) + (col - row)] = 0;
            }
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        solve(0, board, leftRow, lowerDiagonal, upperDiagonal, res);
        return res;
    }

    public static void main(String[] args) {
        int numberOfQueens = 4;
        List<List<String>> queen = solveNQueens(numberOfQueens);
        System.out.println(queen);
    }
}
