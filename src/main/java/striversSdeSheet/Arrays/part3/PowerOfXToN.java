package main.java.striversSdeSheet.Arrays.part3;

/**
 * Logic explanation: -
 * 2 ^ 10 = (2 * 2) ^ 5 = 4 ^ 5
 * 4 ^ 5 = 4 * 4 ^ 4 = 4 * 256 (from next step calculation ie ans)
 * 4 ^ 4 = (4 * 4) ^ 2 = 16 ^ 2
 * 16 ^ 2 = (16 * 16) ^ 1 = 256 ^ 1
 * 256 ^ 1 = 256 * 256^0 = 256 (Considered above)
 *
 * when n % 2 == 0 then x * x and reduce n by n/2
 * when n % 2 == 1 then ans * x and reduce n by n - 1
 *
 * for negative value: -
 * 2 ^ (-2) = 1 / (2 ^ 2) so calculate 2 ^ 2 and at last calculate 1/ans
 */
public class PowerOfXToN {

    public static double myPow(double x, int n) {
        double ans = 1.0;
        long tempN = n;
        if (tempN < 0) {
            tempN = -1 * tempN;
        }

        while (tempN > 0) {
            if (tempN % 2 == 1) {
                ans = ans * x;
                tempN = tempN - 1;
            } else {
                x = x * x;
                tempN = tempN / 2;
            }
        }
        if (n < 0) {
            ans = 1.0 / ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0000, -2));
    }
}
