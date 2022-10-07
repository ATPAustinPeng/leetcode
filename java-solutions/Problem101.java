/*
    101. Symmetric Tree

    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Example 1:
    Input: root = [1,2,2,3,4,4,3]
    Output: true

    Example 2:
    Input: root = [1,2,2,null,3,null,3]
    Output: false

    Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100
 */

public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymmetricHelper(root.right, root.left);
    }
    
    private boolean isSymmetricHelper(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        } else if (right != null && left == null) {
            return false;
        } else if (right == null && left != null) {
            return false;
        }
        
        if (right.val != left.val) {
            return false;
        }
        
        return isSymmetricHelper(right.right, left.left) && isSymmetricHelper(right.left, left.right);
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
