package main.java.striversSdeSheet.BinarySearch;

public class MedianOfTwoSortedArray {

    //Intuition is to get left1, left2, right1 & right2 for comparison. Because for finding median we need
    //2 element in case of even length or 1 element in case of odd length
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //Apply binary search on smaller size array
        if (n2 < n1) return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;

        while (low <= high) {
            //Find out cut1 as breaking point for array1 & cut2 as breaking point for array2
            int cut1 = (low + high) / 2;
            //(n1 + n2 + 1) / 2) -> This will give the half of total element (works for both even & odd number of element) - cut1
            int cut2 = ((n1 + n2 + 1) / 2) - cut1;

            //Edge cases:
            //If cut1 is 0 means not picking any element from array.
            //So, assign it as min value for comparison.
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];    //picking cut1 - 1 as left value
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];    //picking cut2 - 1 as left value

            //If cut1 is n means picking all the elements from array. So, no element left for right half.
            //So, assign it as max value for comparison.
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];  //picking cut1 as right value
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];  //picking cut1 as right value

            //Idea is if we combine both array so, it should be sorted one.
            //If we are dividing it from any index, left half values will be smaller than right half.
            //So just ensuring by below condition, if we are cutting the arrays properly or not.
            //Hence, doing cross array element check because since array is sorted then comparing left1 with
            //right1 & left2 with right 2 will always be true.
            if (left1 <= right2 && left2 <= right1) {
                //As per intuition above
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) { //if left1 from 1st array is greater than right1 of second array
                //Left1 ko kam karna padega toh high ko kam karo.
                high = cut1 - 1;
            } else { //if left2 from 1st array is greater than right2 of second array
                //left2 ko chota krna padega, jiske liye left1 ko badhana padega. toh low ko aage lekar jaao
                //left1 ko badhaaenge tab hi left2 me kam values aaenge. Since array is sorted toh kam value,
                //matlab moving towards lower side.
                low = cut1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

    }
}
