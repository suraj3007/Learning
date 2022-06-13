package main.java.wissen;

import java.util.ArrayList;
import java.util.List;

public class LarrysArray {
    public static String larrysArray(List<Integer> A) {
        int inversionCount = 0;
        for(int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) > A.get(j)) {
                    inversionCount++;
                }
            }
        }

        return inversionCount % 2 == 0 ? "YES" : "NO";
    }

    private static List<Integer> rotateList(List<Integer> list) {

        return null;
    }
}
