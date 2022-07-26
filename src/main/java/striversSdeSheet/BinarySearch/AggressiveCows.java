package main.java.striversSdeSheet.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {

    public static boolean canPlaceCows(int[] positions, int numberOfCows, int minDist) {
        int lastPlacedCow = positions[0], count = 1;
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - lastPlacedCow >= minDist) {
                count++;
                lastPlacedCow = positions[i];
            }
            if (count == numberOfCows) return true;
        }
        return false;
    }

    public static int largestMinimumDistance(int[] positions, int numberOfCows) {
        Arrays.sort(positions);
        int low = positions[0], high = positions[positions.length - 1] - positions[0];
        int res = -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (canPlaceCows(positions, numberOfCows, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int a[]={1,2,8,4,9};
        System.out.println(largestMinimumDistance(a, 3));
    }
}
