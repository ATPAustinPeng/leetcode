/*
    42. Trapping Rain Water

    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9

    Constraints:
    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105
*/

public class Problem42 {
    public int trap(int[] height) {
        // two pointer
        int leftPtr = 0;
        int rightPtr = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        
        int result = 0;
        
        while (leftPtr < rightPtr) {
            if (height[leftPtr] < height[rightPtr]) {
                if (height[leftPtr] >= leftMax) {
                    leftMax = height[leftPtr];
                } else {
                    result += (leftMax - height[leftPtr]);
                }
                leftPtr++;
            } else {
                if (height[rightPtr] >= rightMax) {
                    rightMax = height[rightPtr];
                } else {
                    result += (rightMax - height[rightPtr]);
                }
                rightPtr--;
            }
        }
        
        return result;
        
        // stack solution: O(n) time, O(n) space
//         Stack<Integer> s = new Stack<>();
//         int currIndex = 0;
//         int result = 0;
        
//         while (currIndex < height.length) {
//             while (!s.isEmpty() && height[currIndex] > height[s.peek()]) {
//                 int trapIndex = s.pop();
                
//                 if (s.isEmpty()) {
//                     break;
//                 }
                
//                 // width = distance from rightMax to leftMax
//                 // boundedHeight = height of water trap
//                     // ex. 4 2 3 (boundedHeight = 1 -> min(4, 3) - 2)
//                 int width = currIndex - s.peek() - 1;
//                 int boundedHeight = Math.min(height[currIndex], height[s.peek()]) - height[trapIndex];
//                 result += width * boundedHeight;
//             }
//             s.push(currIndex++);
//         }
        
//         return result;
        
        // DP: O(n) time, O(n) space
        // max height upto given point from left to right & right to left
//         int[] leftMax = new int[height.length];
//         int result = 0;
        
//         int currMax = height[0];
//         for (int i = 0; i < height.length; i++) {
//             if (height[i] > currMax) {
//                 currMax = height[i];
//             }
//             leftMax[i] = currMax;           
//         }
        
//         int[] rightMax = new int[height.length];
//         currMax = height[height.length - 1];
//         for (int i = height.length - 1; i >= 0; i--) {
//             if (height[i] > currMax) {
//                 currMax = height[i];
//             }
//             rightMax[i] = currMax;
//         }
        
//         for (int i = 0; i < height.length; i++) {
//             result += Math.min(leftMax[i], rightMax[i]) - height[i];    
//         }
//         return result;
        
        
        // BAD: brute force O(n^2), O(1) space
        // find leftMax && rightMax for each position i
        // update waterAmt += min(leftMax, rightMax) - height[i]
//         int result = 0;
        
//         for (int i = 1; i < height.length - 1; i++) {
//             int leftMax = 0;
//             int rightMax = 0;
//             for (int j = i - 1; j >= 0; j--) {
//                 leftMax = Math.max(leftMax, height[j]);
//             }
            
//             for (int j = i + 1; j < height.length; j++) {
//                 rightMax = Math.max(rightMax, height[j]);
//             }
            
//             int temp = Math.min(leftMax, rightMax) - height[i];
//             if (temp > 0) {
//                 result += temp;
//             }
//         }
        
//         return result;
    }
}