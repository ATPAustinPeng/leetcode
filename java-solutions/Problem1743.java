/*
    1743. Restore the Array From Adjacent Pairs

    There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
    You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
    It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
    Return the original array nums. If there are multiple solutions, return any of them.

    Example 1:
    Input: adjacentPairs = [[2,1],[3,4],[3,2]]
    Output: [1,2,3,4]
    Explanation: This array has all its adjacent pairs in adjacentPairs.
    Notice that adjacentPairs[i] may not be in left-to-right order.

    Example 2:
    Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
    Output: [-2,4,1,-3]
    Explanation: There can be negative numbers.
    Another solution is [-3,1,4,-2], which would also be accepted.

    Example 3:
    Input: adjacentPairs = [[100000,-100000]]
    Output: [100000,-100000]

    Constraints:
    nums.length == n
    adjacentPairs.length == n - 1
    adjacentPairs[i].length == 2
    2 <= n <= 105
    -105 <= nums[i], ui, vi <= 105
    There exists some nums that has adjacentPairs as its pairs.
*/

public class Problem1743 {
        public int[] restoreArray(int[][] adjacentPairs) {
        // build a graph
        // find the source/sink nodes (node connects only to one other node)
        // dfs from source/sink node & build solution array with nodes passed
        
        int[] result = new int[adjacentPairs.length + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // build undirect graph
        for (int[] edge : adjacentPairs) {
            // getOrDefault essentially means, if edge[0] isn't in the graph, create an ArrayList
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0], list);
            
            // Note: add both pairings for undirected graph
            list = graph.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }
        
        // dfs (uses stack because fifo)
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            // find source/sink node (should only have 1 neighbor)
            if (entry.getValue().size() == 1) {
                stack.add(entry.getKey());
                break;
            }
        }
        
        int index = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            
            // add int to result
            result[index++] = curr;
            
            // mark visited nodes
            visited.add(curr);
            
            // add node's neighbors to stack
            for (int neighbor : graph.get(curr)) {
                if (!visited.contains(neighbor)) {
                    stack.add(neighbor);
                }
            }
        }
        
        return result;
    }
}