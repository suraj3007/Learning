package main.java.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayIntoChunk {
    public static void main(String[] args) {
        int[] original = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int splitSize = 3;

		/* expected Output
		[0, 1, 2]
		[3, 4, 5]
		[6, 7, 8]
		[9]
		*/

        List<int[]> list = splitArray(original, splitSize);
        list.forEach(splitArray -> System.out.println(Arrays.toString(splitArray)));
    }

    public static List<int[]> splitArray(int[] array, int splitSize) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i<array.length; i = i + splitSize){
            list.add(Arrays.copyOfRange(array, i, Math.min(array.length, i + splitSize)));
        }
        return list;
    }
}
