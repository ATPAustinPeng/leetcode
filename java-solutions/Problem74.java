/*
    74. Search a 2D Matrix

    Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.
    
    Example 1:
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true

    Example 2:
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    Output: false

    Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104
*/

public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: everything is 0-indexed
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int middle = (left + right) / 2;
            // int middleRow = middle / n;
            // int middleCol = middle % n;
            
            int middleVal = matrix[middle / n][middle % n];
            
            if (middleVal > target) {
                right = middle - 1;
            } else if (middleVal < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}