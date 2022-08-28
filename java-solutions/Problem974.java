/*
    974. Subarray Sums Divisible by K

    Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
    A subarray is a contiguous part of an array.

    Example 1:
    Input: nums = [4,5,0,-2,-3,1], k = 5
    Output: 7
    Explanation: There are 7 subarrays with a sum divisible by k = 5:
    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
    
    Example 2:
    Input: nums = [5], k = 9
    Output: 0

    Constraints:
    1 <= nums.length <= 3 * 104
    -104 <= nums[i] <= 104
    2 <= k <= 104
 */

public class Problem974 {
    public int subarraysDivByK(int[] nums, int k) {
        // in an array, store the # of occurrences of each possible remainder from dividing by k
        // loop through hashmap (note: n = number of occurrences with that remainder)
            // if remainder doesn't exist, then no possible subarray sum is divisible by k
            // if remainder == 0, then we have n + n(n-1)/2 possibilities
            // if remainder != 0, then we have n(n-1)/2 possibilities
        // ex. nums = [..., 1, 4, 0, 1, ...], k = 5
        //      sum = [..., 1, 5, 5, 6, ...]
        //       %k = [..., 1, 0, 0, 1, ...], but we can see that from 1 to 6, the remainders are the same and the subarrays is divisible
        /*  {
                0: 2,
                1: 2,
            }
            for 0, we count 2 + 2(2-1)/2 = 3 subarray (2 subarrays of 1 element + 1 subarray of 2C2 subarrays)
            note: n choose 2 because we are counting all possible start and end points of a subarray from n possible occurences
            note: no dividing/rounding issue since n(n-1) will always produce an even number
        */
        
        int[] remArr = new int[k];
        int currSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            
            // need to add k after modding (since -2 mod 5 = -2)
            // need to mod k at the end (since 2 mod 5 = 2 + 5 = 7 needs to get modded)
            int rem = ((currSum % k) + k) % k;
            remArr[rem]++;
        }
        
        int result = remArr[0];
        for (int i = 0; i < remArr.length; i++) {
            result += remArr[i] * (remArr[i] - 1) / 2;
        }
        
        return result;
    }
}
