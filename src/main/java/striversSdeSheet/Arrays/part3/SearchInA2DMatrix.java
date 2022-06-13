package main.java.striversSdeSheet.Arrays.part3;

public class SearchInA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int low = 0, high = (rowLen * colLen) - 1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (matrix[mid / colLen][mid % colLen] == target) {
                return true;
            }
            if (target > matrix[mid / colLen][mid % colLen]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
    }
}

