package main.java.learning;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "geeksgeeksrof";
        char[] arr = s.toCharArray();

        Integer count;
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : arr) {
            count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, ++count);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        System.out.print("First Non-Repeating character is : ");

        for (Map.Entry<Character, Integer> m : entrySet) {
            if (m.getValue() == 1) {
                System.out.print(m.getKey().toString().toLowerCase() + " ");
                break;
            }
        }
    }
}
