package main.java.striversSdeSheet.Arrays.part2;

//TODO: - 1 test case is failing
public class RepeatAndMissingNumber {
    public static int[] repeatedNumber(final int[] A) {
        int n = A.length;
        int[] ans = new int[2];
        long summation = (n * (n + 1)) / 2;
        long summationSquare = (n * (n + 1) * (2 * n + 1)) / 6;

        for (int i = 0; i < n; i++) {
            summation -= A[i];
            summationSquare -= A[i] * A[i];
        }

        long sumNum = summationSquare/summation;
        int missingNumber = (int) (summation + sumNum) / 2;
        int repeatedNumber = (int) (missingNumber - summation);

        ans[0] = repeatedNumber;
        ans[1] = missingNumber;
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,5,3};

        int[] ans = repeatedNumber(A);

        for (int i : ans) {
            System.out.print(i + " ");
        }

    }
}
