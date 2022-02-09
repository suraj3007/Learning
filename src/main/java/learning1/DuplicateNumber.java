package main.java.learning1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class FindDuplicate {
    public static void main(String[] args) {
        int arr[] = {0, 4, 3, 8, 3, 8, 2, 3, 0};
        //int[] arr = {3, 3, 3, 3, 3, 3};

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            Integer count = map.get(n);

            if (count == null) {
                map.put(n, 1);
            } else {
                count += 1;
                map.put(n, count);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        System.out.println("Repeating elements are : ");
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
            }
        }

    }
}

class FindDuplicate2 {
    public static void main(String[] args) {
        int arr[] = {0, 4, 3, 8, 7, 8, 2, 3, 0};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate values " + arr[j]);
                }
            }
        }
    }
}




class DuplicateNumber {

    public static void main(String args[]) {
        int numRay[] = {0, 4, 3, 8, 7, 8, 2, 3, 1};

        for (int i = 0; i < numRay.length; i++) {
            numRay[numRay[i] % numRay.length] = numRay[numRay[i] % numRay.length] + numRay.length;
        }

        System.out.println("The repeating elements are : ");

        for (int i = 0; i < numRay.length; i++) {
            if (numRay[i] >= numRay.length*2) {
                System.out.println(i + " ");
            }
        }
    }
}