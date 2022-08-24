/*
    200. Number of Islands

    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

    Example 1:
    Input: grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
    ]
    Output: 1

    Example 2:
    Input: grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
    ]
    Output: 3
    
    Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
*/

public class Problem200 {
    public int numIslands(char[][] grid) {
        // iterate through each spot on the grid
        // floodfill if the grid spot contains 1, replacing all 1s with 0
        // keep track of the number of times floodfill was called to return
        
        int numIslands = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // if land
                if (grid[i][j] == '1') {
                    floodFill(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    
    private void floodFill(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        
        if (grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        floodFill(grid, i + 1, j);
        floodFill(grid, i - 1, j);
        floodFill(grid, i, j + 1);
        floodFill(grid, i, j - 1);
    }
}