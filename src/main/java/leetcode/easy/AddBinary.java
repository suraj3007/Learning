package main.java.leetcode.easy;

public class AddBinary {

    public String addBinary(String a, String b) {
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int carry = 0;

        StringBuilder res = new StringBuilder();
        while (aLength >= 0 || bLength >= 0) {
            int sum = carry;

            if (aLength >= 0) {
                //Char ‘0’ → 48 (Int) , Char ‘1’ → 49(Int)
                sum += a.charAt(aLength--) - '0';
            }

            if (bLength >= 0) {
                sum += b.charAt(bLength--) - '0';
            }

            res.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            res.insert(0, 1);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        long x = 10;
        int i = 11;
        if (x < i) {

        }
    }
}
