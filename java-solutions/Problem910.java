/*
    910. Smallest Range II

    You are given an integer array nums and an integer k.
    For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
    The score of nums is the difference between the maximum and minimum elements in nums.
    Return the minimum score of nums after changing the values at each index.

    Example 1:
    Input: nums = [1], k = 0
    Output: 0
    Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.

    Example 2:
    Input: nums = [0,10], k = 2
    Output: 6
    Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.

    Example 3:
    Input: nums = [1,3,6], k = 3
    Output: 3
    Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.

    Constraints:
    1 <= nums.length <= 104
    0 <= nums[i] <= 104
    0 <= k <= 104
 */

public class Problem910 {
    public int smallestRangeII(int[] nums, int k) {
        // sort the array O(n log n)
        // nums[i] + k, nums[nums.length - i - 1] - k
        // track smallest range by tracking min(nums[0] + k, nums[i + 1] - k) and max(nums[nums.length - 1] - k, nums[i] + k)
        
        // if length of array is 1, smallest range is 0
        if (nums.length == 1) {
            return 0;
        }
        
        // sort the array
        Arrays.sort(nums);
        
        int result =  nums[nums.length - 1] - nums[0];
        
        for (int i = 0; i < nums.length - 1; i++) {
            // base comparison:
                // min -> the smallest value + k
                // max -> the largest value - k
            // compare with:
                // min -> every value - k since [1, 3, 6], k = 3, initially nums[0] is min, but nums[1] - k is the real min
                // max -> every value + k since [1, 3, 6], k = 3, initially nums[2] is max, but nums[1] + k is the real max
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            int max = Math.max(nums[nums.length - 1] - k, nums[i] + k);
            result = Math.min(result, max - min);
        }
        return result;
    }
}
