package main.java.striversSdeSheet.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / (double)a.weight;
            double r2 = (double) b.value / (double)b.weight;
            if (r1 < r2) return 1;
            else if (r1 > r2) return -1;
            else return 0;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n)
    {
        //Sort the object in decreasing order of value/weight
        Arrays.sort(arr, new ItemComparator());
        int currentWeight = 0;
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            //If we can take complete weight
            if (currentWeight + arr[i].weight <= W) {
                currentWeight += arr[i].weight;
                result += arr[i].value;
            } else { //If fraction of weight needs to be taken.
                int remain = W - currentWeight;
                result += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
