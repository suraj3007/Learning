package main.java.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenArray {

    public static void main(String[] args) throws Exception {
        Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
        Integer[] flattenedArray = flatten2(array);

        System.out.println(Arrays.toString(flattenedArray));
    }

    public static Integer[] flatten(Object[] inputArray) {
        List<Integer> list = new ArrayList<>();
        for (Object obj : inputArray) {
            if (obj instanceof Integer) {
                list.add((Integer) obj);
            } else {
                list.addAll(Arrays.asList(flatten((Object[]) obj)));
            }
        }
        return list.toArray(new Integer[0]);
    }

    public static Integer[] flatten2(Object[] inputArray) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(inputArray)
                .forEach(obj -> {
                    if (obj instanceof Integer) {
                        list.add((Integer) obj);
                    } else {
                        list.addAll(Arrays.asList(flatten((Object[]) obj)));
                    }
                });
        return list.toArray(new Integer[0]);
    }
}
