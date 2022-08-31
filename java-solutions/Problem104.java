/*
    104. Maximum Depth of Binary Tree

    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3

    Example 2:
    Input: root = [1,null,2]
    Output: 2

    Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
 */

public class Problem104 {
    public int maxDepth(TreeNode root) {
        // dfs
        return dfs(root);
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return Math.max(dfs(node.right), dfs(node.left)) + 1;
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
