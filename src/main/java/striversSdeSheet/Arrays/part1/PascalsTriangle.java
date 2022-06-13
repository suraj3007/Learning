package main.java.striversSdeSheet.Arrays.part1;

import java.util.ArrayList;
import java.util.List;

//TC: - O(N * N)
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, prev = null;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = row;
            res.add(row);
        }
        return res;
    }

    public static List<List<Long>> generate2(int numRows) {
        List<List<Long>> res = new ArrayList<>();
        List<Long> row, prev = null;

        //Handle each row
        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            //Make an entry for individual column of that particular row
            for (int j = 0; j <= i; j++) {
                //first & last column value will be 1
                if (j == 0 || j == i) {
                    row.add(1L);
                } else {
                    //Sum of values of prev & current indexes/columns from prev derived row.
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = row;
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
        System.out.println(generate(numRows).get(3).get(1));
    }
}
