package main.java.wissen;

import java.util.*;

public class MakingAnagrams {
    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        int matchedCharacter = 0;
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        List<Character> s2CharArrayToList = new ArrayList<>();
        for (char ch : s2CharArray){
            s2CharArrayToList.add(ch);
        }

        for (char ch : s1CharArray) {
            if (s2CharArrayToList.contains(ch)) {
                matchedCharacter++;
                s2CharArrayToList.remove(new Character(ch));
            }
        }

        return (s1CharArray.length + s2CharArray.length) - (matchedCharacter * 2);
    }

    public static void main(String[] args) {
        String s1 = "cde";
        String s2 = "abc";
        System.out.println(makingAnagrams(s1, s2));
    }
}
