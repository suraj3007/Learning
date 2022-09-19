package main.java.striversSdeSheet.String.part1;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        String[] s1 = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].length() != 0) {
                if (res.length() != 0) {
                    res.append(" ");
                }
                res.append(s1[i]);
            }
        }
        return res.toString();
    }

    public static String reverseWordsUsingTrim(String s) {
        String[] s1 = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            res.append(s1[i]).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = "  Hello    World  ";
        System.out.println(reverseWordsUsingTrim(s));
    }
}
