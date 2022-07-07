/*
    1762. Buildings With an Ocean View

    There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
    The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
    Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

    Example 1:
    Input: heights = [4,2,3,1]
    Output: [0,2,3]
    Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.

    Example 2:
    Input: heights = [4,3,2,1]
    Output: [0,1,2,3]
    Explanation: All the buildings have an ocean view.

    Example 3:
    Input: heights = [1,3,2,4]
    Output: [3]
    Explanation: Only building 3 has an ocean view.
    
    Constraints:
    1 <= heights.length <= 105
    1 <= heights[i] <= 109
*/

public class Problem1762 {
    public int[] findBuildings(int[] heights) {
        // start from right to left (rightmost always has ocean view)
        // track max height from right to left
        // any house with larger max height has an ocean view
            // add index of houses with ocean view to a List (newer entries go to front)
        
        int max = -1;
        List<Integer> houseIndices = new ArrayList<>();
        
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                houseIndices.add(i);
            }
        }
        
        int[] result = new int[houseIndices.size()];
        for (int i = houseIndices.size() - 1; i >= 0; i--) {
            result[houseIndices.size() - 1 - i] = houseIndices.get(i);
        }
        
        return result;
    }
}