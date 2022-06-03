/*
    283. Move Zeroes

    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    
    Example 2:
    Input: nums = [0]
    Output: [0]

    Constraints:
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1
*/

public class Problem283 {
    public void moveZeroes(int[] nums) {
        // zeroes can occur anywhere, but they're placement doesn't matter
        // essentially collect all the non-zero elements
        // and let the rest of the array after non-zero elements be 0
        
        int nonZeroIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}