/*
    4. Median of Two Sorted Arrays

    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).

    Example 1:
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

    Example 2:
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    
    Constraints:
    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106
 */

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int firstLen = nums1.length;
    int secondLen = nums2.length;
    
    int firstPtr = 0;
    int secondPtr = 0;
    
    int prevMed = 0;
    int med = 0;
    
    while (firstPtr + secondPtr <= (firstLen + secondLen) / 2) {
        prevMed = med;
        if (firstPtr == firstLen) {
            med = nums2[secondPtr++];
        } else if (secondPtr == secondLen) {
            med = nums1[firstPtr++];
        } else if (nums1[firstPtr] < nums2[secondPtr]) {
            med = nums1[firstPtr++];
        } else {
            med = nums2[secondPtr++];
        }
    }
    
    // if there is an even amt of numbers, median is the average of the 2 "middle numbers"
    if ((firstLen + secondLen) % 2 == 0) {
        return (prevMed + med) / 2.0;
    }
    
    return med;
}