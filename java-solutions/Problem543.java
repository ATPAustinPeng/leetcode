/*
    543. Diameter of Binary Tree

    Given the root of a binary tree, return the length of the diameter of the tree.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    The length of a path between two nodes is represented by the number of edges between them.

    Example 1:
    Input: root = [1,2,3,4,5]
    Output: 3
    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

    Example 2:
    Input: root = [1,2]
    Output: 1

    Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -100 <= Node.val <= 100

 */

public class Problem543 {
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        getMaxDiameter(root);
        
        return diameter;
    }
    
    private int getMaxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int lDiameter = getMaxDiameter(root.left);
        int rDiameter = getMaxDiameter(root.right);
        
        diameter = Math.max(diameter, lDiameter + rDiameter);
        
        return Math.max(lDiameter, rDiameter) + 1;
    }
    
    // finds actual path of longest diameter
//     List<Integer> max;
    
//     public int diameterOfBinaryTree(TreeNode root) {
//         max = new ArrayList<>();
//         rec(root);
//         System.out.println(max);
//         return 0;
//     }

//     private List<Integer> rec(TreeNode root) {
//         if(root == null)
//             return new ArrayList<>();

//         List<Integer> l = rec(root.left);
//         List<Integer> r = rec(root.right);

//         if (l.size() >= r.size()) {
//             l.add(root.val);
//         } else {
//             r.add(root.val);
//         }

//         Collections.reverse(r);
//         List<Integer> temp = new ArrayList<>();
//         temp.addAll(l);
//         temp.addAll(r);

//         max = max.size() >= temp.size() ? max : temp;

//         return l.size() >= r.size() ? l : r; 
//     }
}
