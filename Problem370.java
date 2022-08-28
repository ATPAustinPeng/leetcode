/*
    370. Range Addition

    You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
    You have an array arr of length length with all zeros, and you have some operation to apply on arr.
    In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
    Return arr after applying all the updates.

    Example 1:
    Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
    Output: [-2,0,3,5,3]

    Example 2:
    Input: length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]
    Output: [0,-4,2,2,2,4,4,-4,-4,-4]

    Constraints:
    1 <= length <= 105
    0 <= updates.length <= 104
    0 <= startIdxi <= endIdxi < length
    -1000 <= inci <= 1000
 */

public class Problem370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        // THIS SOLUTION IS O(n + k); naive solution results in O(nk)
        // iterate through updates O(k)
            // mark result[updates[start]] with += updates[amt]
            // mark result[updates[end + 1]] with -= updates[amt]
            // leverage prefix summing (at start -> add, at end -> decrement prefix sum by the same amt)
            // ex.
                // result = [0, 2, 0, 0, -2]
                // result = [0, 2, 3, 0, -2]
                // result = [-2, 2, 3, 2, -2]
        // iterate through result and perform prefix sum O(n)
            // prefix sum -> result[i] += result[i - 1]
            // ex.
                // result = [-2, 0, 3, 5, 3]
        
        int[] result = new int[length];
        
        // iterate through updates
        for (int[] update : updates) {
            int left = update[0];
            int right = update[1];
            int amt = update[2];
            
            // mark the beginning of the update (for prefix sum)
            // Note: prefix sum would perform '+amt' until the below 'if statement' is reached
            result[left] += amt;
            
            // mark the end of the update (for prefix sum)
            // Note: prefix sum would already be running with '+amt' from start of update, when end is reached do '-amt'
            if (right + 1 < length) {
                result[right + 1] -= amt;
            }
        }
        
        // leverage prefix sum to get the final answer
        for (int i = 1; i < length; i++) {
            result[i] += result[i - 1];
        }
        
        return result;
    }
}
