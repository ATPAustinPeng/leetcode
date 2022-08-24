/*
    1861. Rotating the Box

    You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
        A stone '#'
        A stationary obstacle '*'
        Empty '.'
    The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. 
    Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. 
    Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
    It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
    Return an n x m matrix representing the box after the rotation described above.

    Example 1:
    Input: box = [["#",".","#"]]
    Output: [["."],
            ["#"],
            ["#"]]

    Example 2:
    Input: box = [["#",".","*","."],
                ["#","#","*","."]]
    Output: [["#","."],
            ["#","#"],
            ["*","*"],
            [".","."]]

    Example 3:
    Input: box = [["#","#","*",".","*","."],
                ["#","#","#","*",".","."],
                ["#","#","#",".","#","."]]
    Output: [[".","#","#"],
            [".","#","#"],
            ["#","#","*"],
            ["#","*","."],
            ["#",".","*"],
            ["#",".","."]]
    
    Constraints:
    m == box.length
    n == box[i].length
    1 <= m, n <= 500
    box[i][j] is either '#', '*', or '.'.
*/
public class Problem1861 {
    public char[][] rotateTheBox(char[][] box) {
        // assume gravity is right on original array and move stones row by row
        for (char[] row: box) {
            int empty = row.length - 1;
            for (int i = row.length - 1; i >= 0; i--) {
                if (row[i] == '#') {
                    row[i] = '.';
                    row[empty] = '#';
                    // if (empty != i) {
                    //     row[i] = '.';
                    // }
                    empty -= 1;
                } else if (row[i] == '*') {
                    empty = i - 1;  // refers to i otherwise stone will fall through the obstacle
                }
            }
        }
        
        // rotate the array (aka transpose & mirror)
        char[][] rotatedBox = new char[box[0].length][box.length];
        
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                rotatedBox[j][box.length - i - 1] = box[i][j];
            }
        }
        return rotatedBox;
    }
}