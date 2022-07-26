package main.java.striversSdeSheet.BinarySearch;

public class NthrootOfAnInteger {

    private static double multiply(double m, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans = ans * m;
        }
        return ans;
    }
    public static double findNthRootOfM(int n, long m) {
        // Write your code here.
        double low = 1, high = m;
        double eps = 1e-6;

        while ((high - low) > eps) {
            double mid = (high + low) / 2.0;
            if (multiply(mid, n) > m) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(findNthRootOfM(3, 27));
    }
}
