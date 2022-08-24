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
        // bfs (queue, left to right level order)
        // track how many elements in the same level using queue size
        
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(new ArrayList<>(Arrays.asList(root.val)));
        if (root.left != null) {
            q.add(root.left);   
        }

        if (root.right != null) {
            q.add(root.right);    
        }
        
        // optimization
        int level = 1;
        while (!q.isEmpty()) {
            result.add(new ArrayList<>());
            
            int numNodesOnLevel = q.size();
            for (int i = 0; i < numNodesOnLevel; i++) {
                TreeNode temp = q.remove();
                result.get(level).add(temp.val);
                
                if (temp.left != null) {
                    q.add(temp.left);   
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            level++;
        }
        
        // slightly more space complex than needed
//         int numNodesOnLevel = q.size();
//         List<Integer> sameLevelList = new ArrayList<>();
//         while (!q.isEmpty()) {
//             TreeNode temp = q.remove();
//             if (temp.left != null) {
//                 q.add(temp.left);   
//             }
            
//             if (temp.right != null) {
//                 q.add(temp.right);    
//             }
            
//             sameLevelList.add(temp.val);
            
//             numNodesOnLevel--;
            
//             if (numNodesOnLevel == 0) {
//                 numNodesOnLevel = q.size();
//                 result.add(sameLevelList);
//                 sameLevelList = new ArrayList<>();
//             }
//         }
        
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