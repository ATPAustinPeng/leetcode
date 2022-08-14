/*
    1254. Number of Closed Islands

    Given a 2D grid consists of 0s (land) and 1s (water).
    An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
    Return the number of closed islands.

    Example 1:
    Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
    Output: 2
    Explanation: 
    Islands in gray are closed because they are completely surrounded by water (group of 1s).

    Example 2:
    Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
    Output: 1
    
    Example 3:
    Input: grid = [[1,1,1,1,1,1,1],
                [1,0,0,0,0,0,1],
                [1,0,1,1,1,0,1],
                [1,0,1,0,1,0,1],
                [1,0,1,1,1,0,1],
                [1,0,0,0,0,0,1],
                [1,1,1,1,1,1,1]]
    Output: 2

    Constraints:
    1 <= grid.length, grid[0].length <= 100
    0 <= grid[i][j] <=1
*/

public class Problem1254 {
    public int closedIsland(int[][] grid) {
        int numClosedIslands = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (isClosedIsland(grid, i, j)) {
                        numClosedIslands++;
                    }
                }
            }
        }
        return numClosedIslands;
    }
    
    public boolean isClosedIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        
        if (grid[i][j] == 1) {
            return true;
        }
        
        // assume it is a closed island and set water to land
        grid[i][j] = 1;
        
        // use && comparison, if one fails, it is not a closed island
        boolean result = isClosedIsland(grid, i + 1, j) && isClosedIsland(grid, i - 1, j) && isClosedIsland(grid, i, j + 1) && isClosedIsland(grid, i, j - 1);
        
        // if turns out is not a closed island, reset land back to water
        // Note: we can only set isClosedIsland land to water, since it is surrounded by water
        // Note: if not a closed island and we set land to water, it will mess up other closed islands
        if (!result) {
            grid[i][j] = 0;
        }
        
        return result;
    }
}