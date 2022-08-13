/*
    1658. Minimum Operations to Reduce X to Zero

    You are given an integer array nums and an integer x.
    In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x.
    Note that this modifies the array for future operations.
    Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

    Example 1:
    Input: nums = [1,1,4,2,3], x = 5
    Output: 2
    Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

    Example 2:
    Input: nums = [5,6,7,8,9], x = 4
    Output: -1

    Example 3:
    Input: nums = [3,2,20,1,1,3], x = 10
    Output: 5
    Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
    
    Constraints:
    1 <= nums.length <= 105
    1 <= nums[i] <= 104
    1 <= x <= 109
*/

public class Problem1658 {
        public int minOperations(int[] nums, int x) {
        // two pointers (time complexity: O(n), space complexity O(1))
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        
        // find shortest required operations to sum to x == find longest subarray with sum of total - x
        int k = total - x;
        int maxLen = -1;
        int left = 0;
        int currTotal = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currTotal += nums[right];
            
            while (currTotal > k && left <= right) {
                currTotal -= nums[left++];
            }
            
            if (currTotal == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen == -1 ? -1 : nums.length - maxLen;
        
        // TOO SLOW... (time complexity: O(2n), space complexity O(n))
        // we are only allowed to remove elements from left and right
        // aka if we find the maximum subarray with sum = sum(nums) - k
        // then len(nums) - len(maxSubarray)
        // otherwise return 0
        // variant of 325. Maximum Size Subarray Sum Equals K
        
//         int currPrefixSum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             currPrefixSum += nums[i];
//         }
        
//         int k = currPrefixSum - x;
        
//         // cover for special case where you remove all elements of num (return can't handle this and the non-existing case)
//         if (k == 0) {
//             return nums.length;
//         }
        
//         Map<Integer, Integer> hmap = new HashMap<>();
//         int prefixSum = 0;
//         int lenLongestSubarray = -1;
        
        
        // case 1: prefixSum is nums[0 ... i]
            // just return len(nums) - len(maxSubarray)
        // case 2: prefixSum is nums[index ... i] (index is found from hmap)
            // aka prefixSum - nums[i] 
            // just return len(nums) - (i - index)
//         for (int i = 0; i < nums.length; i++) {
//             prefixSum += nums[i];
//             if (prefixSum == k) {
//                 lenLongestSubarray = i + 1;
//             } else if (hmap.containsKey(prefixSum - k)) {
//                 lenLongestSubarray = Math.max(lenLongestSubarray, i - hmap.get(prefixSum - k));
//             }
            
//             if (!hmap.containsKey(prefixSum)) {
//                 hmap.put(prefixSum, i);
//             }
//         }
//         return lenLongestSubarray == -1 ? -1 : nums.length - lenLongestSubarray;
    }
}