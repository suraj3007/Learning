package main.java.wissen;

import java.util.*;

public class HackerRankInString {
    public static String hackerrankInString(String s) {
        // Write your code here
        Queue<Character> queue = new ArrayDeque<>();
        char[] charArray = {'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k'};
        List<Character> list = new ArrayList<>();
        for(char ch : charArray) {
            queue.add(ch);
        }

        charArray = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if (!queue.isEmpty() && charArray[i] == queue.peek()) {
                list.add(queue.poll());
            } else if (list.contains(charArray[i]) || !queue.isEmpty()) {
                continue;
            } else {
                return "NO";
            }
        }

        return queue.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        String s = "rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt";
        System.out.println(hackerrankInString(s));
    }
}
