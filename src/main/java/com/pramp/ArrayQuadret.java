package main.java.com.pramp;

import java.util.*;

class Solution {

    //2 7 4 0 9 5 1 3 6 8 24

    static int[] findArrayQuadruplet(int[] arr, int s) {
        int n = arr.length;
        int r, low, high;
        Arrays.sort(arr);//4 4 4 4
        for (int i = 0; i < n - 4; i++) {
            for (int j = i + 1; j < n - 3; j++) {
                r = s - (arr[i] + arr[j]);
                low = j + 1;
                high = n - 1;

                while (low < high) {
                    if (arr[low] + arr[high] < r) {
                        low++;
                    } else if (arr[low] + arr[high] > r) {
                        high--;
                    } else {
                        return new int[]{arr[i], arr[j], arr[low], arr[high]};
                    }
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {4,4,4,4};
        int s = 16;
        List<Integer> l = new ArrayList<>();
        if(arr.length < 4){
            System.out.println("[]");
            //System.out.println("Time taken " + (System.currentTimeMillis() - ts));
            return;
        }
        int[] result = findArrayQuadruplet(arr, s);
        for (int i : result) {
            l.add(i);
        }
        System.out.println(l);
        //System.out.println("Time taken " + (System.currentTimeMillis() - ts));
    }
}


//class ArrayDuplet{
//    public static void main(String[] args) {
//        Integer[] values = {7, 6, 9, 1, 4, 8, 2};
//        int sum = 16;
//        findDuplet(values, sum);
//    }
//
//    private static void findDuplet(Integer[] values, int sum) {
//        Arrays.sort(values);
//        int n = values.length;
//        List val = Arrays.asList(values);
//        for (int i = 0; i < n-1 ; i++){
//            int r = sum - values[i];
//            if(val.contains(r)){
//                System.out.println("[" +values[i] + "," +r +"]");
//                //break; //If we want only 1 value to print
//            }
//        }
//    }
//}


class ArrayTriplet{
    public static void main(String[] args) {
        Integer[] values = {7, 6, 9, 1, 4, 8, 2};
        int sum = 16;
        findDuplet(values, sum);
    }

    private static void findDuplet(Integer[] values, int sum) {
        Arrays.sort(values);
        int n = values.length;
        List val = Arrays.asList(values);
        for (int i = 0; i < n-1 ; i++){
            int r = sum - values[i];
            if(val.contains(r)){
                System.out.println("[" +values[i] + "," +r +"]");
                //break; //If we want only 1 value to print
            }
        }
    }
}
