/*
	Problem 153. Find Minimum in Rotated Sorted Array

	Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
	[4,5,6,7,0,1,2] if it was rotated 4 times.
	[0,1,2,4,5,6,7] if it was rotated 7 times.
	Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
	Given the sorted rotated array nums of unique elements, return the minimum element of this array.
	You must write an algorithm that runs in O(log n) time.

	Example 1:
	Input: nums = [3,4,5,1,2]
	Output: 1
	Explanation: The original array was [1,2,3,4,5] rotated 3 times.

	Example 2:
	Input: nums = [4,5,6,7,0,1,2]
	Output: 0
	Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

	Example 3:
	Input: nums = [11,13,15,17]
	Output: 11
	Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
	
	Constraints:
	n == nums.length
	1 <= n <= 5000
	-5000 <= nums[i] <= 5000
	All the integers of nums are unique.
	nums is sorted and rotated between 1 and n times.
*/

public class Problem153 {
	public int findMin(int[] nums) {
        // binary search (from middle of array) to determine where the array is decreasing
        // there should only be one location because the array pre-rotation was sorted
        // 2 cases:
        // (1) nums[0] is min, nums[nums.length] is max
        // (2) the minimum is anywhere else in the array
        
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        
        // loop will terminate on left < right as left will always get incremented by 1
        // solution will be located at the left pointer since left is being incremented
        while (left < right) {
            // checking the nums[right] works better since if the array has an even number,
            // the calculation for mid will pick the element to the "left" of the actual mid
            // ex. 0, 1, 2, 3 -> mid picks 1
            if (nums[mid] < nums[right]) {
                // right = mid - 1 doesn't work
                // since nums[mid] might be the minimum as it is smaller than nums[right]
                right = mid;
                mid = (left + right) / 2;
            } else {
                // left = mid + 1 works
                // since nums[mid] >= nums[right] means nums[mid] is not the smallest value
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return nums[left];
}