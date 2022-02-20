/*
    Problem 33. Search in Rotated Sorted Array
    There is an integer array nums sorted in ascending order (with distinct values).
    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

    Example 3:
    Input: nums = [1], target = 0
    Output: -1

    Constraints:
    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104
*/

public class Problem33 {
    // just a list of some failed test cases... before I got it to work
    // i still don't understand why some lines have <= over < and why left <= right
    // not left < right...
    public static void main(String[] args) {
        Problem33 p33 = new Problem33();
        int[] nums = new int[] { 1, 3 };
        int target = 3;
        // int[] nums = new int[] { 3, 1 };
        // int target = =1;
        // int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        // int target = 3;
        // int[] nums = new int[] { 1 };
        // int target = 1;
        System.out.println("result: " + p33.search(nums, target));
    }

    public int search(int[] nums, int target) {
        // essentially binary search
        // one side of the array will be sorted in increasing order
        // just determine which side the target is located in
        // nums[mid] < nums[right] -> right side sorted
        // right = mid
        // nums[left] < nums[mid] -> left side sorted
        // left = mid + 1

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
}