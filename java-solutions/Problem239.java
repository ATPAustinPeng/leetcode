/*
    239. Sliding Window Maximum
    
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window.
    Each time the sliding window moves right by one position.
    Return the max sliding window.

    Example 1:
    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]
    Explanation: 
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7
    
    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    1 <= k <= nums.length
 */

public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        if (nums.length == 1) {
            return nums;
        }
        
        Deque<Integer> dq = new LinkedList<>();
        int maxIndex = 0;
        
        // populate first set of k elements into sliding window (deque)
        for (int i = 0; i < k; i++) {
            // Note: no need to remove element not in curr sliding window (since we are adding the first k elements)
            
            // remove elements less than the curr value so sliding window can track the max (remove from right end)
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            
            // Note: don't update result array here, since we haven't reached the end of the deque
        }
        
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[dq.getFirst()];
        
        for (int i = k; i < nums.length; i++) {
            // remove element not in curr sliding window (remove from left end)
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            
            // remove elements less than the curr value so sliding window can track the max (remove from right end)
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            result[i - k + 1] = nums[dq.getFirst()];
        }
        return result;
    }
}
