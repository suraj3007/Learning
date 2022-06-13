package main.java.striversSdeSheet.Arrays.part2;

import java.util.ArrayList;

public class RotateMatrix {

    /**
     * Step 1: find transpose of a matrix -> Transpose: Column becomes row & row becomes column
     * Step 2: reverse each row of a matrix
     * Intuition behind this logic: - If you see row in rotated output matrix, it is reverse of column
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        //Step 1 implemented
        for(int i = 0; i < matrix.length; i++) {
            //Here j = i because 1st row and 1st column is already transposed.
            //In next iteration, we don't have to start with previous column otherwise values again get swapped.
            for(int j = i; j < matrix.length; j++) {
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Step 2 implemented
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length/2; j++) {
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    /*public static void rotate2(ArrayList<ArrayList<Integer>> matrix) {
        //Step 1 implemented
        for(int i = 0; i < matrix.size(); i++) {
            //Here j = i because 1st row and 1st column is already transposed.
            //In next iteration, we don't have to start with previous column otherwise values again get swapped.
            for(int j = i; j < matrix.size(); j++) {
                int temp;
                temp = matrix.get(i).get(j);
                matrix;
                matrix[j][i] = temp;
            }
        }

        //Step 2 implemented
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.size()/2; j++) {
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.size() - 1 - j];
                matrix[i][matrix.size() - 1 - j] = temp;
            }
        }
    }*/

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
