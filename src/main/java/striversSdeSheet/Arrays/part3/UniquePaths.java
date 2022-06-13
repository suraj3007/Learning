package main.java.striversSdeSheet.Arrays.part3;

/**
 * Google interview question : Combination problem
 * for 2 * 3 matrix:-> m = 2, n = 3
 * Observation 1: Possible combination: R-R-D, D-R-R, R-D-R : It means 3 steps are required to reach an end point
 * Observation 2: 2 right direction means col - 1 and 1 downward direction mean row - 1 => col + row - 2
 * Conclusion: - Out of total steps (m + n - 2) of C to the base either (m - 1) OR (m + n - 2)C(n - 1)
 */
public class UniquePaths {

    //Full optimized solution
    public static int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int R = m - 1; // OR n - 1;
        double res = 1;

        for (int i = 1; i <= R; i++) {
            res = res * (N - R + i) / i;
        }
        return (int) res;
    }

    //-------------------------------------------------------------------------------------------

    public static int uniquePathsUsingRecursion(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        } else if (i >= m || j >= n) {
            return 0;
        }
        return uniquePathsUsingRecursion(i + 1, j, m, n) + uniquePathsUsingRecursion(i, j + 1, m, n);
    }

    //brute force solution
    public static int findUniquePathsUsingRecursion(int m, int n) {
        return uniquePathsUsingRecursion(0, 0, m, n);
    }

    //-------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(findUniquePathsUsingRecursion(3, 7));
        System.out.println(findUniquePathsUsingRecursionOptimized(3, 7));
    }

    //-------------------------------------------------------------------------------------------

    //Optimized solution using Dynamic programming
    public static int findUniquePathsUsingRecursionOptimized(int m, int n) {
        int[][] arr = new int[m][n];
        return uniquePathsUsingRecursionOptimized(0, 0, m, n, arr);
    }

    public static int uniquePathsUsingRecursionOptimized(int i, int j, int m, int n, int[][] arr) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        } else if (i >= m || j >= n) {
            return 0;
        } else if (arr[i][j] != 0) {
            return arr[i][j];
        }
        return arr[i][j] = uniquePathsUsingRecursion(i + 1, j, m, n) + uniquePathsUsingRecursion(i, j + 1, m, n);
    }
}
