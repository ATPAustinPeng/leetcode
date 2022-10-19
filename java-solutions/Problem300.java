/*
    300. Longest Increasing Subsequence

    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
    For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

    Example 1:
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    Example 2:
    Input: nums = [0,1,0,3,2,3]
    Output: 4

    Example 3:
    Input: nums = [7,7,7,7,7,7,7]
    Output: 1

    Constraints:
    1 <= nums.length <= 2500
    -104 <= nums[i] <= 104
    

    Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */

public class Problem300 {
    public int lengthOfLIS(int[] nums) {
        // creating a subsequence
        // but when a nums[i] doesn't increase length of the subsequence
            // replace the smallest value in the subsequence it is bigger than
        
        List<Integer> subseq = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (subseq.size() == 0) {
                subseq.add(nums[i]);
            }
            
            if (nums[i] > subseq.get(subseq.size() - 1)) {
                subseq.add(nums[i]);
            } else {
                int index = lbBinarySearch(subseq, nums[i]);
                subseq.set(index, nums[i]);
            }
        }
        
        return subseq.size();
        
        // dp, base case LIS = 1
//         int n = nums.length;
//         int[] dp = new int[n];
        
//         Arrays.fill(dp, 1);
        
//         for (int i = n - 1; i >= 0; i--) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[j] > nums[i] && dp[j] + 1 > dp[i]) {
//                     dp[i] = dp[j] + 1;
//                 }
//             }
//         }
        
//         int max = 1;
        
//         for (int i = 0; i < n; i++) {
//             max = Math.max(dp[i], max);
//         }
        
//         return max;
    }
    
    private int lbBinarySearch(List<Integer> lst, int val) {
        int l = 0;
        int r = lst.size() - 1;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (lst.get(mid) < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
}