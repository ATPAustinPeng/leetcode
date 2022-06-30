/*
    46. Permutations

    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

    Example 3:
    Input: nums = [1]
    Output: [[1]]
    
    Constraints:
    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
*/

public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        
        int startIndex = 0;
        int endIndex = nums.length;
        
        recurse(result, numsList, startIndex, endIndex);
        
        return result;
    }
    
    private void recurse(List<List<Integer>> result, List<Integer> numsList, int startIndex, int endIndex) {
        // list has been permuted completely
        if (startIndex == endIndex) {
            result.add(new ArrayList<Integer>(numsList));
        }
        
        // swap startIndex and i, recurse, then reset the numsList for next iteration's swap
        for (int i = startIndex; i < endIndex; i++) {
            swap(numsList, startIndex, i);
            recurse(result, numsList, startIndex + 1, endIndex);
            swap(numsList, startIndex, i);
        }
    }
    
    // swaps nums[a] with nums[b]
    private void swap(List<Integer> numsList, int a, int b) {
        int temp = numsList.get(a);
        numsList.set(a, numsList.get(b));
        numsList.set(b, temp);
    }
}