package main.java.striversSdeSheet.Arrays.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubIntervals {

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] n : intervals) {
            if (n[0] <= end) {
                end = Math.max(end, n[1]);
            } else {
                res.add(new int[]{start, end});
                start = n[0];
                end = n[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int res[][] = merge(intervals);
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
