/*
	238. Product of Array Except Self

	Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
	You must write an algorithm that runs in O(n) time and without using the division operation.
	
	Example 1:
	Input: nums = [1,2,3,4]
	Output: [24,12,8,6]

	Example 2:
	Input: nums = [-1,1,0,-3,3]
	Output: [0,0,9,0,0]

	Constraints:
	2 <= nums.length <= 105
	-30 <= nums[i] <= 30
	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/

public class Problem238 {
	public int[] productExceptSelf(int[] nums) {
		// 2-pass solution
        // left to right -> in an array, track product of all elements before the index
        // ex. [1, 2, 3 ,4] will result in [1, 1, 2, 6]
        // right to left -> in an array track product of all elements after the index
        // ex. [1, 2, 3 ,4] will result in [24, 12, 4, 1]
        // do these two passes together (for O(1) extra space)
        
        int len = nums.length;
        int[] result = new int[len];
        
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        int rightToLeftProd = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = result[i] * rightToLeftProd;
            rightToLeftProd *= nums[i];
        }
        return result;
	}
}
