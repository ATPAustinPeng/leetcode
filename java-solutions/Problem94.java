/*
    94. Binary Tree Inorder Traversal

    Given the root of a binary tree, return the inorder traversal of its nodes' values.
    
    Example 1:
    Input: root = [1,null,2,3]
    Output: [1,3,2]

    Example 2:
    Input: root = []
    Output: []

    Example 3:
    Input: root = [1]
    Output: [1]
    
    Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
 */

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        dfs(root, lst);
        return lst;
    }
    
    private void dfs(TreeNode node, List<Integer> lst) {
        if (node == null) {
            return;
        }
        
        dfs(node.left, lst);
        lst.add(node.val);
        dfs(node.right, lst);
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
