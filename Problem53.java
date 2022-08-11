/*
	53. Maximum Subarray
	
	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	A subarray is a contiguous part of an array.

	Example 1:
	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.

	Example 2:
	Input: nums = [1]
	Output: 1

	Example 3:
	Input: nums = [5,4,-1,7,8]
	Output: 23
	
	Constraints:
	1 <= nums.length <= 105
	-104 <= nums[i] <= 104

	Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Problem53 {
	public int maxSubArray(int[] nums) {
		public int maxSubArray(int[] nums) {
        // dp array (bad & unnecessary)
            // tracks maxSubarraySum up to i
            // dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
            // iterate through dp to find max val
        // use single int to track currSubarraySum
            // currSubarraySum is updated with currSubarraySum + nums[i]
            // or just nums[i] (which takes care of contiguous aspect)
        
        
        int currSubarraySum = nums[0];
        
        int maxSubarraySum = currSubarraySum;
        for (int i = 1; i < nums.length; i++) {
            currSubarraySum = Math.max(currSubarraySum + nums[i], nums[i]);
            maxSubarraySum = Math.max(currSubarraySum, maxSubarraySum);
        }
        
        return maxSubarraySum;
    }
}
