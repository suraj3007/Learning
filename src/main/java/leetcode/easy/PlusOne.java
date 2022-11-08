package main.java.leetcode.easy;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            i--;
        }

        //All digits are 9. For eg. 9,9,9,9 => So output should be 1,0,0,0,0. Here, size of array will increase by 1
        if (i == -1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        //Otherwise, i will be at position which is non 9. So, we will increment digit of that position by 1.
        //And another loop will copy all the previous position elements into resultant array.
        //In this case, size of array will be same.
        int[] result = new int[digits.length];
        result[i] = digits[i] + 1;

        for (int j = 0; j < i; j++) {
            result[j] = digits[j];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
