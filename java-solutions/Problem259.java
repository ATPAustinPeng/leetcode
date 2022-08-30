/*
    259. 3Sum Smaller
    
    Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

    Example 1:
    Input: nums = [-2,0,1,3], target = 2
    Output: 2
    Explanation: Because there are two triplets which sums are less than 2:
    [-2,0,1]
    [-2,0,3]

    Example 2:
    Input: nums = [], target = 0
    Output: 0

    Example 3:
    Input: nums = [0], target = 0
    Output: 0
    
    Constraints:
    n == nums.length
    0 <= n <= 3500
    -100 <= nums[i] <= 100
    -100 <= target <= 100
 */

public class Problem259 {
    public int threeSumSmaller(int[] nums, int target) {
        // two pointers O(n^2)
            // for it to work, we must sort the array
            // fix one pointer (outer loop)
            // use left right pointers to find the number of threeSumSmallers (inner loop)
                // if nums[left] + nums[right] >= target, cannot ever include nums[right], right--
                // if nums[left] + nums[right] < target, include all between left and right, left++

        if (nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int result = 0;
        
        // Note: only pick the first number up to nums.length - 2, since we need at least 3 numbers
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int currTarget = target - nums[i];
            
            // if the 3x the smallest number >= target, break
            if (nums[i] * 3 >= target) {
                break;
            }
            
            while (left < right) {
                if (nums[left] + nums[right] < currTarget) {
                    result += right - left;
                    left++;
                } else if (nums[left] + nums[right] >= currTarget) {
                    right--;
                }
            }
        }
        
        return result;
    }
}
