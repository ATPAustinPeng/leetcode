/*
    384. Shuffle an Array

    Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

    Implement the Solution class:

    Solution(int[] nums) Initializes the object with the integer array nums.
    int[] reset() Resets the array to its original configuration and returns it.
    int[] shuffle() Returns a random shuffling of the array.
    

    Example 1:
    Input
        ["Solution", "shuffle", "reset", "shuffle"]
        [[[1, 2, 3]], [], [], []]
    Output
        [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

    Explanation
        Solution solution = new Solution([1, 2, 3]);
        solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                            // Any permutation of [1,2,3] must be equally likely to be returned.
                            // Example: return [3, 1, 2]
        solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
        solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

    Constraints:
    1 <= nums.length <= 50
    -106 <= nums[i] <= 106
    All the elements of nums are unique.
    At most 104 calls in total will be made to reset and shuffle.
*/

public class Problem384 {
    private int[] original;
    private int[] shuffled;

    // Note: nums is a pointer to an array of ints, so we must copy if we edit them both
    public Solution(int[] nums) {
        original = nums;
        shuffled = Arrays.copyOf(nums, nums.length);
    }
    
    public int[] reset() {
        shuffled = Arrays.copyOf(original, original.length);
        return original;
    }
    
    public int[] shuffle() {
        // math.random to select a num from 0 ... nums.length - 1 to swap
        int randomIndex = 0;
        
        for (int i = 0; i < original.length; i++) {
            // note: Math.random -> [0, 1)
            // get rand index from i to end of array
            randomIndex = (int) (Math.random() * (original.length - i)) + i; 
            swap(i, randomIndex);
        }
        return shuffled;
    }
    
    private void swap(int i, int j) {
        int temp = shuffled[i];
        shuffled[i] = shuffled[j];
        shuffled[j] = temp;
    }

    /**
    * Your Solution object will be instantiated and called as such:
    * Solution obj = new Solution(nums);
    * int[] param_1 = obj.reset();
    * int[] param_2 = obj.shuffle();
    */
}