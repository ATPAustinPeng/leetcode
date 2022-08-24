/*
    325. Maximum Size Subarray Sum Equals k

    Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there is not one, return 0 instead.

    Example 1:
    Input: nums = [1,-1,5,-2,3], k = 3
    Output: 4
    Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.

    Example 2:
    Input: nums = [-2,-1,2,1], k = 1
    Output: 2
    Explanation: The subarray [-1, 2] sums to 1 and is the longest.
    
    Constraints:
    1 <= nums.length <= 2 * 105
    -104 <= nums[i] <= 104
    -109 <= k <= 109
*/

public class Problem325 {
    // track currPrefixSum
        // HashMap tracks previous prefixSums and their end index
        
        // if there exists subarray from i to j summing to k
            // prefixSum[j] - prefixSum[i - 1] = k
            // prefixSum[j] - k = prefixSum[i - 1]
        // so if HashMap contains prefixSum[j] - k, then you know a subarray exists summing to k from i to j with length j - (i - 1) + 1 (includes value at i - 1) - 1 (excludes value at i - 1) since we subtracted it out when calculating k above

        Map<Integer, Integer> hmap = new HashMap<>();
        int prefixSum = 0;
        int lenLongestSubarray = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                lenLongestSubarray = i + 1;
            } else if (hmap.containsKey(prefixSum - k)) {
                lenLongestSubarray = Math.max(lenLongestSubarray, i - hmap.get(prefixSum - k));
            }
            
            if (!hmap.containsKey(prefixSum)) {
                hmap.put(prefixSum, i);
            }
        }
        return lenLongestSubarray;
    }
}