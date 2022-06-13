package main.java.striversSdeSheet.Arrays.part2;

//Prerequisite: Merge sort
//2 test cases are failing
public class InversionOfArray {

    private static long merge(long[] arr, long[] temp, int left, int mid, int right){
        int inversion_count = 0;
        //i -> index for left sub-array, j -> index for right sub-array, k ->  index for temp array
        int i = left, j = mid, k = left;

        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                inversion_count = inversion_count + (mid - i);
            }
        }

        while (i <= mid  - 1) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversion_count;
    }

    private static long mergeSort(long[] arr, long[] temp, int left, int right) {
        int inversion_count = 0;
        int mid;

        if (right > left) {
            mid = (right + left)/2;
            inversion_count += mergeSort(arr, temp, left, mid);
            inversion_count += mergeSort(arr, temp, mid + 1, right);

            inversion_count += merge(arr, temp, left, mid + 1, right);
        }
        return inversion_count;
    }

    public static long getInversions(long arr[], int n) {
        long[] temp = new long[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    public static void main(String[] args) {
        long[] arr = {2, 5, 1, 3, 4};
        System.out.println(getInversions(arr,arr.length));
    }
}
