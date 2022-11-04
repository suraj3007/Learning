package main.java.striversSdeSheet.String.part2;

public class ZFunction {

    public static int strStr(String haystack, String needle) {
        // Easiest way
        // return needle.length() == 0 ? 0 : haystack.indexOf(needle);
        if (needle.length() == 0) return 0;

        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < haystack.length()) {
            if (haystack.charAt(pointer1) != needle.charAt(pointer2)){
                //This will bring back pointer1 to the index where it found first character match.
                //And pointer1++ at line 22 will move it to next index and it will start scanning again
                //from next index to find a match with first character of needle
                pointer1 -= pointer2;
                pointer2 = 0;
            } else {
                pointer2++;
            }
            pointer1++;
            if (pointer2 == needle.length()){
                //To get the start point
                return pointer1 - pointer2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississipi";
        String needle = "issip";

        System.out.println(strStr(haystack, needle));
    }

    //Coding ninja variation : To find count of all occurrences
    //s = aabbbb, p = bb :- **output -> 3 and not 2.**
    public static int zAlgorithm(String s, String p, int n, int m) {
        // Write your code here
        int count = 0;
        if (m > n) return count;
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < n) {
            if (pointer2 == m || s.charAt(pointer1) != p.charAt(pointer2)) {
                pointer1 -= pointer2;
                pointer2 = 0;
            } else {
                pointer2++;
            }
            pointer1++;
            if (pointer2 == m) {
                count++;
            }
        }

        return count;

    }
}
