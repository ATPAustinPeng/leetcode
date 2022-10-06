/*
    733. Flood Fill

    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
    To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
    Replace the color of all of the aforementioned pixels with color.
    Return the modified image after performing the flood fill.

    Example 1:
    Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
    Output: [[2,2,2],[2,2,0],[2,0,1]]
    Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
    Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

    Example 2:
    Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
    Output: [[0,0,0],[0,0,0]]
    Explanation: The starting pixel is already colored 0, so no changes are made to the image.

    Constraints:
    m == image.length
    n == image[i].length
    1 <= m, n <= 50
    0 <= image[i][j], color < 216
    0 <= sr < m
    0 <= sc < n
*/

public class Problem733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        floodFillHelper(image, sr, sc, color, visited, image[sr][sc]);
        
        return image;
    }
    
    private void floodFillHelper(int[][] image, int sr, int sc, int color, boolean[][] visited, int prevColor) {
        // index out of bounds
        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) {
            return;
        }
        
        // if index has been visited before
        if (visited[sr][sc] == true) {
            return;
        }
        
        // if color at index is not the same as the starting color
        if (image[sr][sc] != prevColor) {
            return;
        }
        
        visited[sr][sc] = true;
        image[sr][sc] = color;
        
        floodFillHelper(image, sr + 1, sc, color, visited, prevColor);
        floodFillHelper(image, sr - 1, sc, color, visited, prevColor);
        floodFillHelper(image, sr, sc + 1, color, visited, prevColor);
        floodFillHelper(image, sr, sc - 1, color, visited, prevColor); 
    }
}