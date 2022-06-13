package main.java.striversSdeSheet.Arrays.part4;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithXorAsK {

    public static int solve(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, xor = 0;
        for (int j : A) {
            xor = xor ^ j;
            if (xor == B) {
                count += 1;
            }
            if (map.containsKey(xor ^ B)) {
                count += map.get(xor ^ B);
            }
            if (map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 6, 4};
        System.out.println(solve(A, 6));
    }
}
