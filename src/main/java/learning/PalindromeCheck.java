package main.java.learning;

public class PalindromeCheck {
    public static void main(String[] args) {
        String s = " naman";
        System.out.println(isPalindrome(s) ?
                "String is palindrome.." :
                "String is not palindrome..");
    }

    private static boolean isPalindrome(String s) {

        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
