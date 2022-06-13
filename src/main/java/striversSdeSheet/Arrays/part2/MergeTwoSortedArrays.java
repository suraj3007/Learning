package main.java.striversSdeSheet.Arrays.part2;

//TODO: Needs to work on this logic
public class MergeTwoSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i, j;
        for (i = 0; i < m; i++) {
            if (nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
            } else if (nums1[i] == 0) {
                for (j = 0; j < n; j++){
                    nums1[i] = nums2[j];
                    i +=1;
                }
                return;
            }

            int first = nums2[0];
            for (j = 1; j < n && nums2[j] < first; j++){
                nums2[j - 1] = nums2[j];
            }
            nums2[j - 1] = first;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1, nums1.length, nums2, nums2.length);

        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
