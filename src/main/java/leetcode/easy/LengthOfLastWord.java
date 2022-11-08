package main.java.leetcode.easy;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();   //to remove leading and trailing spaces
        int start = s.length() - 1;
        int count = 0;

        for (int i = start; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
