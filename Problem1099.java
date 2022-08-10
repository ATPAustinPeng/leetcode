/*
    1099. Two Sum Less Than K

    Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.

    Example 1:
    Input: nums = [34,23,1,24,75,33,54,8], k = 60
    Output: 58
    Explanation: We can use 34 and 24 to sum 58 which is less than 60.
    
    Example 2:
    Input: nums = [10,20,30], k = 15
    Output: -1
    Explanation: In this case it is not possible to get a pair sum less that 15.
    
    Constraints:
    1 <= nums.length <= 100
    1 <= nums[i] <= 1000
    1 <= k <= 2000
*/
public class Problem1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        // two pointer solution
            // sort array
            // if twoSum >= k, right--
            // if twoSum < k, left++
        
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        
        int maxTwoSum = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int twoSum = nums[left] + nums[right];
            if (twoSum >= k) {
                right--;
            } else if (twoSum < k) {
                left++;
            }
            
            // Note: still check for max you don't terminate once you find max, you might keep going and find
            // non max twoSum (ex. k = 10, [1, 2, 3, 4, 7] -> finds 8 -> 9 -> 10 (no update) -> 7, returns 7)
            if (twoSum < k) {
                maxTwoSum = twoSum;
            }
        }
        return maxTwoSum;
    }
}