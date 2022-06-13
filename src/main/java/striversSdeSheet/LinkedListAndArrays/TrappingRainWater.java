package main.java.striversSdeSheet.LinkedListAndArrays;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;

        while (left <= right) {
            //Check 1: It ensures that on right side, we will have value higher than left
            if (height[left] <= height[right]) {

                //If no maximum at left, then wont be able to trap water
                if (maxLeft <= height[left])
                    maxLeft = height[left];
                else
                    //if maximum at left, then water can be trapped at current index
                    //Check 1 ensures that we will have maximum at right
                    res += maxLeft - height[left];

                left++;

            } else {

                //If no maximum at right, then wont be able to trap water
                if (maxRight <= height[right])
                    maxRight = height[right];

                else
                    //if maximum at right, then water can be trapped at current index
                    //Check 1 ensures that we will have some minimal at left
                    res += maxRight - height[right];

                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
