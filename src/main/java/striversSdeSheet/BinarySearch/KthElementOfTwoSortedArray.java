package main.java.striversSdeSheet.BinarySearch;

public class KthElementOfTwoSortedArray {

    //Intuition explained in MedianOfTwoSortedArray.java
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if (m < n) return kthElement(arr2, arr1, m, n, k);

        //To handle edge cases like if k < arr1.size or k > arr2.size because from above condition
        //we ensure that arr1 will be lesser size & arr2. is of greater size.
        int low = Math.max(0,k - m), high = Math.min(k, n);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            //To make sure that k element resides on left half after proper cut into halves
            int cut2 = k - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int right1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                //since we are making sure to have k element on left half, we can return maximum of l1,l2
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
