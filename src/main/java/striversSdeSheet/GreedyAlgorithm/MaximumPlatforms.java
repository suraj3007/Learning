package main.java.striversSdeSheet.GreedyAlgorithm;

import java.util.Arrays;

public class MaximumPlatforms {

    static int findPlatform(int arr[], int dep[], int n) {
        //Sorting both will change the indexes of train timings but at the end arrival & departure time matters.
        //If train is arriving, it will occupy the platform & while leaving, it will leave the platform vacant.
        //So, we are just gonna play with train timings of an entire day.
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            result = Math.max(result, plat_needed);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(findPlatform(arr,dep, arr.length));
    }

}
