package main.java.striversSdeSheet.String.part1;

public class LongestPalindromeInAString {

    static int resultStart;
    static int resultLength;

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;  //Even 1/0 char is palindrome

        for (int start = 0; start < len - 1; start++) {
            expandRange(s, start, start);       //for odd length
            expandRange(s, start, start + 1);   //for even length
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private static void expandRange(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
