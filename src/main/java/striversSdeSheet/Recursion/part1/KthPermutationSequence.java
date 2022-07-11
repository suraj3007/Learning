package main.java.striversSdeSheet.Recursion.part1;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {

    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < n; i++) { //Calculate factorial for n - 1
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1;  //For 0-based indexing
        String ans = "";
        while (true) {
            ans = ans + numbers.get(k / fact); //This will give the number for each index in kth sequence.
            numbers.remove(k / fact);
            if (numbers.isEmpty()) {
                break;
            }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
