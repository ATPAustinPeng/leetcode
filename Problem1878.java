/*
    1878. Get Biggest Three Rhombus Sums in a Grid
    You are given an m x n integer matrix grid​​​.
    A rhombus sum is the sum of the elements that form the border of a regular rhombus shape in grid​​​. The rhombus must have the shape of a square rotated 45 degrees with each of the corners centered in a grid cell. Below is an image of four valid rhombus shapes with the corresponding colored cells that should be included in each rhombus sum:
    Note that the rhombus can have an area of 0, which is depicted by the purple rhombus in the bottom right corner.
    Return the biggest three distinct rhombus sums in the grid in descending order. If there are less than three distinct values, return all of them.

    Example 1:
    Input: grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
    Output: [228,216,211]
    Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
    - Blue: 20 + 3 + 200 + 5 = 228
    - Red: 200 + 2 + 10 + 4 = 216
    - Green: 5 + 200 + 4 + 2 = 211

    Example 2:
    Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [20,9,8]
    Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
    - Blue: 4 + 2 + 6 + 8 = 20
    - Red: 9 (area 0 rhombus in the bottom right corner)
    - Green: 8 (area 0 rhombus in the bottom middle)
    
    Example 3:
    Input: grid = [[7,7,7]]
    Output: [7]
    Explanation: All three possible rhombus sums are the same, so return [7].
    
    Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    1 <= grid[i][j] <= 105
*/
public class Problem1878 {
    public int[] getBiggestThree(int[][] grid) {
        // build rhombuses from every grid point
        // starting with "up" node & extending "left", "right", "down"
        // and tracking sums
        
        int m = grid.length; // up to down
        int n = grid[0].length; // left to right
        
        int up, left, right, down, sum;
        up = left = right = down = sum = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < m; i++) {
            // up = i;
            for (int j = 0; j < n; j++) {
                left = right = j;
                down = i;
                while (left >= 0 && right <= n - 1 && down <= m - 1) {
                    sum = calcSum(grid, i, down, left, right);
                    
                    left--;
                    right++;
                    down += 2;
                    
                    if (pq.size() < 3) {
                        if (!pq.contains(sum)) {
                            pq.add(sum);    
                        }
                    } else {
                        if (sum > pq.peek() && !pq.contains(sum)) {
                            pq.poll();
                            pq.add(sum);
                        }
                    }
                }
            }
        }
        
        int[] result = new int[pq.size()];
        int i = result.length - 1;
        while(!pq.isEmpty()){
            result[i] = pq.remove();
            i--;
        }
        
        return result;
    }
    
    private int calcSum(int[][] grid, int up, int down, int left, int right) {
        // use left & right (x-coord), up (y-coord) to find starting point
        boolean isExpanding = true;
        int x1, x2;
        x1 = x2 = (left + right) / 2;
        
        int sum = 0;
        
        for (int i = up; i <= down; i++) {
            if (x1 == x2) {
                sum += grid[i][x1];
            } else {
                sum += grid[i][x1] + grid[i][x2];
            }
            
            
            if (x1 == left || x2 == right) {
                isExpanding = false;
            }
            
            if (isExpanding) {
                x1--;
                x2++;
            } else {
                x1++;
                x2--;
            }
        }
        
        return sum;
    }
}