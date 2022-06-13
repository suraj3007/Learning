package main.java.striversSdeSheet.Arrays.part1;

//Here, we are taking 0th row and 0th column as dummy indexes for all rows & columns respectively.
//column variable is used to handle 0th column
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        //Variable is used to handle zeroes at column 0. Because it is responsible for row change as well.
        boolean column0 = true;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            //Column zero will be handled by this check
            if (matrix[i][0] == 0) {
                column0 = false;
            }
            //Check from column 1
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        //Start setting zeroes from last element of matrix in order to avoid the change in value at (0,0)
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            //This is used to set 0es at 0th column based on column0 flag
            //0th row will be handled automatically by checking other rows
            if (!column0) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
