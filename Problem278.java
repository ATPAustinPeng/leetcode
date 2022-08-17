/*
    278. First Bad Version

    You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
    Since each version is developed based on the previous version, all the versions after a bad version are also bad.
    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
    You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version.
    You should minimize the number of calls to the API.

    Example 1:
    Input: n = 5, bad = 4
    Output: 4
    Explanation:
    call isBadVersion(3) -> false
    call isBadVersion(5) -> true
    call isBadVersion(4) -> true
    Then 4 is the first bad version.

    Example 2:
    Input: n = 1, bad = 1
    Output: 1

    Constraints:
    1 <= bad <= n <= 231 - 1
*/

public class Problem278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public int firstBadVersion(int n) {
        // binary search
        // Note: int overflow issue with large numbers
        // Note: use 'left' ptr to return (no need to use variable for previous bad version)
            // because of the way mid is calculated
            // 1 2 3 4 (mid is 2) -> left will have the mid
            // 1 2 3 4 5 (mid is 3) -> left or right having mid here doesn't matter bc center is mid
        
        int left = 1;
        int right = n;
        
        // int prevBadVersion = 0;
        while (left <= right) {
            // int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // prevBadVersion = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
        // return prevBadVersion;
    }
}