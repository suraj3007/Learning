package main.java.learning1;

import java.util.ArrayList;
import java.util.List;

public class CheckStringAnagram {

    public static void main(String[] args) {

        String s1 = "geeksforgeeks";
        String s2 = "forgeksgeekse";

        char[] ch = s1.toCharArray();
        int total = 0;

        for (char c : ch) {
            total += c;
        }

        ch = s2.toCharArray();
        for (char c : ch) {
            total -= c;
        }

        System.out.println(total == 0 ?
                "Strings are anagram to each other"
                : "Strings are not anagram to each other");
    }
}


class RemoveCharFromArray {
    public static void main(String[] args) {
        char[] arr = {'s', 'u', 'r', 'a', 'j', 'm', 'i', 'l', 'a', 'n'};

        String s = "milansuraj";


//        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());

        List<Character> list = new ArrayList<>();
        for (char c : arr)
            list.add(c);

        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                list.remove(new Character(s.charAt(i)));
            }
        }

        System.out.println(list);
    }
}
