package main.java.striversSdeSheet.BinarySearch;

public class AllocateMinimumNumberOfPages {

    public static boolean isValidAllocation(int barrier, int[] A, int B) {
        int noOfStudents = 1,  pagesAllocated = 0;
        for (int i = 0; i < A.length; i++) {
            if (pagesAllocated + A[i] > barrier) {
                noOfStudents++;
                pagesAllocated = A[i];

                if (pagesAllocated > barrier) return false;
            } else {
                pagesAllocated += A[i];
            }
        }

        if (noOfStudents > B) {
            return false;
        }

        return true;
    }

    public static int books(int[] A, int B) {
        if (B > A.length) return -1;

        int low = A[0], high = 0, res = -1;
        for (int i = 0; i < A.length; i++) {
            high += A[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValidAllocation(mid, A, B)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
