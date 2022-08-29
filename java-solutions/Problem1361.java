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
                if (potentialRoot == -2) {
                    potentialRoot = i;
                } else {
                    // multiple roots
                    return false;
                }
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
                // multiple parents
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
            // a cycle exists
            return false;
        }

        return true;
    }
//     public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
//         // build tree
//             // check: no nodes have 2 parents
//         Map<Integer, List<Integer>> parentToChild = new HashMap<>();
//         Map<Integer, List<Integer>> childToParent = new HashMap<>();
        
//         for (int i = 0; i < n; i++) {
//             int left = leftChild[i];
//             int right = rightChild[i];
            
//             // if parent doesn't exist, add it
//             if (!parentToChild.containsKey(i)) {
//                 parentToChild.put(i, new ArrayList<>());
//             }
            
//             // if left is not null, add it
//             if (left != -1) {
//                 parentToChild.get(i).add(left);
                
//                 // if left doesn't exist, add parent
//                 // else return false (because it has 2 parents)
//                 if (!childToParent.containsKey(left)) {
//                     childToParent.put(left, new ArrayList<>());
//                     childToParent.get(left).add(i);
//                 } else {
//                     System.out.println("multiple parent");
//                     return false;
//                 }
//             }
            
//             // if right is not null, add it
//             if (right != -1) {
//                 parentToChild.get(i).add(right);
                
//                 // if right doesn't exist, add parent
//                 // else return false (because it has 2 parents)
//                 if (!childToParent.containsKey(right)) {
//                     childToParent.put(right, new ArrayList<>());
//                     childToParent.get(right).add(i);
//                 } else {
//                     System.out.println("multiple parent");
//                     return false;
//                 }
//             }    
//         }
        
//         int potentialRoot = -2;
//         for (int i = 0; i < n; i++) {
//                 // if not a child node
//                 if (!childToParent.containsKey(i)) {
//                     // if potentialRoot not found, i is the root
//                     // else return false (multiple roots)
//                     if (potentialRoot == -2) {
//                         potentialRoot = i;
//                     } else {
//                         System.out.println("multiple root");
//                         return false;
//                     }
//                 }
//             }
            
//             // there is no root
//             if (potentialRoot == -2) {
//                 System.out.println("no root");
//                 return false;
//             }
            
//             // perform bfs
//             Set<Integer> visited = new HashSet<>();
//             Queue<Integer> q = new LinkedList<>();
            
//             // add root node
//             q.add(potentialRoot);
//             // visited.add(0);
            
//             while (!q.isEmpty()) {
//                 int node = q.remove();
//                 visited.add(node);
                
//                 List<Integer> neighbors = parentToChild.get(node);
                
//                 // add left & right children into queue
//                 for (int i = 0; i < neighbors.size(); i++) {
//                     q.add(neighbors.get(i));
//                 }
//             }
            
//             // if visited set contains n nodes, there are no cycles
//             if (visited.size() != n) {
//                 System.out.println(visited.size());
//                 System.out.println("cycle found");
//                 return false;
//             }
            
            
//             return true;
//     }
}
