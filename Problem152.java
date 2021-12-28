/*
	152. Maximum Product Subarray

	Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
	The test cases are generated so that the answer will fit in a 32-bit integer.
	A subarray is a contiguous subsequence of the array.

	Example 1:
	Input: nums = [2,3,-2,4]
	Output: 6
	Explanation: [2,3] has the largest product 6.

	Example 2:
	Input: nums = [-2,0,-1]
	Output: 0
	Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

	Constraints:
	1 <= nums.length <= 2 * 104
	-10 <= nums[i] <= 10
	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/

public class Problem152 {
	public int maxProduct(int[] nums) {
		/*
		 * 2 POINTER APPROACH:
		 * for each element calculate max product from left & right sides, keep max
		 * if element is 0, reset the corresponding sides's product to 1
		 */
		int leftProduct = 1;
		int rightProduct = 1;
		int maxProduct = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			leftProduct *= nums[i];
			rightProduct *= nums[nums.length - 1 - i];

			if (leftProduct > maxProduct) {
				maxProduct = leftProduct;
			}

			if (rightProduct > maxProduct) {
				maxProduct = rightProduct;
			}

			if (leftProduct == 0) {
				leftProduct = 1;
			}

			if (rightProduct == 0) {
				rightProduct = 1;
			}
		}
		return maxProduct;

		/*
		 * ALTERNATIVE 2 POINTER APPROACH:
		 * while traversing the array, track the minimum and maximum product subarray
		 * values
		 * however, if nums[i] < 0, swap max and min
		 */
		// int max = nums[0];
		// int min = nums[0];
		// int answer = nums[0];

		// for (int i = 1; i < nums.length; i++) {
		// 	if (nums[i] < 0) {
		// 		int temp = max;
		// 		max = min;
		// 		min = temp;
		// 	}

		// 	max = Integer.max(nums[i], nums[i] * max);
		// 	min = Integer.min(nums[i], nums[i] * min);

		// 	answer = Integer.max(max, answer);
		// }
		// return answer;
	}
}
