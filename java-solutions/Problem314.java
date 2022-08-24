/*
    314. Binary Tree Vertical Order Traversal

    Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
    If two nodes are in the same row and column, the order should be from left to right.

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: [[9],[3,15],[20],[7]]
    
    Example 2:
    Input: root = [3,9,8,4,0,1,7]
    Output: [[4],[9],[3,0,1],[8],[7]]

    Example 3:
    Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
    Output: [[4],[9,5],[3,0,1],[8,2],[7]]
    
    Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
*/

public class Problem314 {
    /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
    */

    // Note: row is left to right (0 at root), column is top down (0 at root)
    // maps col -> row -> value at (col, row)
    public Map<Integer, ArrayList<Pair<Integer, Integer>>> mapping = new HashMap<>();
    
    // begin iteration for vertical order from this column
    public int minCol = 0;
    
    // end iteration for vertical order at this column
    public int maxCol = 0;
    
    // dfs, visiting left node first (maintaining left to right order)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, 0, 0);
        
        List<List<Integer>> result = new ArrayList<>();
        
        // iterate through each column (least to greatest)
        for (int i = minCol; i <= maxCol; i++) {
            // sort values in the same column by row (left to right)
            Collections.sort(mapping.get(i), new Comparator<Pair<Integer, Integer>>() {
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    return p1.getKey() - p2.getKey();
                }
            });
            
            List<Integer> sortedColumn = new ArrayList<>();
            for (Pair<Integer, Integer> p: mapping.get(i)) {
                sortedColumn.add(p.getValue());
            }
            result.add(sortedColumn);
        }
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col) {
        if (!mapping.containsKey(col)) {
            mapping.put(col, new ArrayList<Pair<Integer, Integer>>());
        }
        
        mapping.get(col).add(new Pair<Integer, Integer>(row, node.val));
        
        this.minCol = Math.min(col, minCol);
        if (node.left != null) {
            dfs(node.left, row + 1, col - 1);
        }
        
        this.maxCol = Math.max(col, maxCol);
        if (node.right != null) {
            dfs(node.right, row + 1, col + 1);
        }
    }
}