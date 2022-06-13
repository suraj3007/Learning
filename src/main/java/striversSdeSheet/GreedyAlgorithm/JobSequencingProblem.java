package main.java.striversSdeSheet.GreedyAlgorithm;

import java.util.Arrays;

public class JobSequencingProblem {

    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    static int[] JobScheduling(Job arr[], int n) {
        // Your code here
        //Sort array in descending order of profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        //identify max deadline to create an array
        int maxi_deadline = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi_deadline) {
                maxi_deadline = arr[i].deadline;
            }
        }

        //creating an array of size = maximum deadline & initializing them to -1
        int[] result = new int[maxi_deadline + 1];
        for (int i = 1; i <= maxi_deadline; i++) {
            result[i] = -1;
        }

        //find count & profit
        //Intuition: - Perform all jobs on last day of its deadline so that other job with lesser deadline can be occupied
        //on previous days to maximize the profits
        //In case, if that day is full then keep going back till 0 to find slot and perform the task.
        int count = 0, maxProfit = 0;
        //For all job ids
        for (int i = 0; i < n; i++) {
            //From deadline day to 0 iteration
            for (int j = arr[i].deadline; j > 0; j--) {
                //Slot found
                if (result[j] == -1) {
                    //If job ids asked to be returned then we can store result[j] = arr[i].id;
                    result[j] = i;
                    count++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[]{count, maxProfit};
    }

    public static void main(String[] args) {

    }
}
