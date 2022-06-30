/*
    47. Permutations II

    Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

    Example 1:
    Input: nums = [1,1,2]
    Output:
    [[1,1,2],
    [1,2,1],
    [2,1,1]]

    Example 2:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    
    Constraints:
    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
*/

public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> hmap = new HashMap<>();
        LinkedList<Integer> createdPermutation = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(nums[i])) {
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            } else {
                hmap.put(nums[i], 1);    
            }
        }
        
        recurse(result, hmap, createdPermutation, nums.length);
        
        return result;
    }
    
    private void recurse(List<List<Integer>> result, Map<Integer, Integer> hmap, LinkedList<Integer> createdPermutation, int size) {
        // list has been permuted completely
        if (createdPermutation.size() == size) {
            result.add(new LinkedList<Integer>(createdPermutation));
        }
        
        // swap startIndex and i, recurse, then reset the numsList for next iteration's swap
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if (value == 0) {
                continue;
            }
            
            // remove possibility
            createdPermutation.addLast(key);
            hmap.put(key, value - 1);
            
            recurse(result, hmap, createdPermutation, size);
            
            // add possbility back
            hmap.put(key, value);
            createdPermutation.removeLast();
        }
    }
}