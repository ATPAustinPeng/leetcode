/*
    235. Lowest Common Ancestor of a Binary Search Tree

    Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
    According to the definition of LCA on Wikipedia:
        “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Example 1:
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
    Explanation: The LCA of nodes 2 and 8 is 6.

    Example 2:
    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    Output: 2
    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
    
    Example 3:
    Input: root = [2,1], p = 2, q = 1
    Output: 2
    
    Constraints:
    The number of nodes in the tree is in the range [2, 105].
    -109 <= Node.val <= 109
    All Node.val are unique.
    p != q
    p and q will exist in the BST.
*/

public class Problem235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 3 cases:
        // p and q on right of root
        // p and q on left of root
        // p or q is the root
        
        // if p and q are right of root, move the root to right
        // if p and q are left of root, move the root to left
        // if p and q are split (note: p and q can be the root), return the root
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        return root;
    }

    /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
    */
}