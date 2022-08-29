/*
    1361. Validate Binary Tree Nodes
    
    You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
    If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
    Note that the nodes have no values and that we only use the node numbers in this problem.

    Example 1:
    Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
    Output: true

    Example 2:
    Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
    Output: false

    Example 3:
    Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
    Output: false

    Constraints:
    n == leftChild.length == rightChild.length
    1 <= n <= 104
    -1 <= leftChild[i], rightChild[i] <= n - 1
 */

public class Problem1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> nodes = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            nodes.add(leftChild[i]);
            nodes.add(rightChild[i]);
        }
        
        int potentialRoot = -2;
        for (int i = 0; i < n; i++) {
            if (!nodes.contains(i)) {
                // potentialRoot = i;
                if (potentialRoot == -2) {
                    potentialRoot = i;
                } else {
                    return false;
                }
                // break;
            }
        }
        
        if (potentialRoot == -2) {
            // no root
            return false;
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        // add root node
        q.add(potentialRoot);

        while (!q.isEmpty()) {
            int node = q.remove();
            
            if (visited.contains(node)) {
                // not a tree
                return false;
                
            }
            
            visited.add(node);

            // List<Integer> neighbors = parentToChild.get(node);

            // add left & right children into queue
            if (leftChild[node] != -1) {
                q.add(leftChild[node]);
            }
            
            if (rightChild[node] != -1) {
                q.add(rightChild[node]);
            }
        }

        // if visited set contains n nodes, there are no cycles
        if (visited.size() != n) {
            return false;
        }

        return true;
    }
}
