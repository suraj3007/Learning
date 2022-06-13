package main.java.striversSdeSheet.Arrays.part2;

public class FindDuplicates {

    /**
     * Linked list cycle method: -
     * Here, we are trying to create a linked list cycle (virtually)
     * Then maintaining slow pointer (move by 1) and fast pointer (move by 2), trying to find te collision point.
     * Once collided, mark fast pointer to zeroth  index and increment both by 1 place.
     * The place where they collide will be the duplicate value.
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            //by 1 place
            slow = nums[slow];
            //by 2 place
            fast = nums[nums[fast]];
        }while (slow != fast);

        //re-mark fast to zero after collision
        fast = nums[0];
        while (slow != fast) {
            //increment both by 1-1 place
            slow = nums[slow];
            fast = nums[fast];
        }
        //collided value will be the duplicate one
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
