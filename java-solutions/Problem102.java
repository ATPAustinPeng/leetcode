/*
    102. Binary Tree Level Order Traversal

    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[9,20],[15,7]]

    Example 2:
    Input: root = [1]
    Output: [[1]]

    Example 3:
    Input: root = []
    Output: []

    Constraints:
    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000
*/

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // bfs track levels
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        if (root == null) {
            return result;
        }
        
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode removed = q.remove();
                level.add(removed.val);
                
                if (removed.left != null) {
                    q.add(removed.left);    
                }
                if (removed.right != null) {
                    q.add(removed.right);    
                }
            }
            result.add(level);    
        }
        return result;
    }

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
}