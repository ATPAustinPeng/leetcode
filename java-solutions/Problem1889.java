/*
    1889. Minimum Space Wasted From Packaging

    You have n packages that you are trying to place in boxes, one package in each box. There are m suppliers that each produce boxes of different sizes (with infinite supply). A package can be placed in a box if the size of the package is less than or equal to the size of the box.

    The package sizes are given as an integer array packages, where packages[i] is the size of the ith package. The suppliers are given as a 2D integer array boxes, where boxes[j] is an array of box sizes that the jth supplier produces.

    You want to choose a single supplier and use boxes from them such that the total wasted space is minimized. For each package in a box, we define the space wasted to be size of the box - size of the package. The total wasted space is the sum of the space wasted in all the boxes.

    For example, if you have to fit packages with sizes [2,3,5] and the supplier offers boxes of sizes [4,8], you can fit the packages of size-2 and size-3 into two boxes of size-4 and the package with size-5 into a box of size-8. This would result in a waste of (4-2) + (4-3) + (8-5) = 6.
    Return the minimum total wasted space by choosing the box supplier optimally, or -1 if it is impossible to fit all the packages inside boxes. Since the answer may be large, return it modulo 109 + 7.

    
    Example 1:
    Input: packages = [2,3,5], boxes = [[4,8],[2,8]]
    Output: 6
    Explanation: It is optimal to choose the first supplier, using two size-4 boxes and one size-8 box.
    The total waste is (4-2) + (4-3) + (8-5) = 6.
    
    Example 2:
    Input: packages = [2,3,5], boxes = [[1,4],[2,3],[3,4]]
    Output: -1
    Explanation: There is no box that the package of size 5 can fit in.
    
    Example 3:
    Input: packages = [3,5,8,10,11,12], boxes = [[12],[11,9],[10,5,14]]
    Output: 9
    Explanation: It is optimal to choose the third supplier, using two size-5 boxes, two size-10 boxes, and two size-14 boxes.
    The total waste is (5-3) + (5-5) + (10-8) + (10-10) + (14-11) + (14-12) = 9.
    
    Constraints:
    n == packages.length
    m == boxes.length
    1 <= n <= 105
    1 <= m <= 105
    1 <= packages[i] <= 105
    1 <= boxes[j].length <= 105
    1 <= boxes[j][k] <= 105
    sum(boxes[j].length) <= 105
    The elements in boxes[j] are distinct.
 */

public class Problem1889 {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int packageLen = packages.length;
        
        long totalPackageSize = 0L;
        for (int pack : packages) {
            totalPackageSize += pack;
        }
        
        long minUsage = Long.MAX_VALUE;
        long mod = 1000000007L;
        
        for (int[] boxSizes : boxes) {
            Arrays.sort(boxSizes);
            if (boxSizes[boxSizes.length - 1] < packages[packageLen - 1]) {
                continue;
            }
            
            long currUsage = 0;
            long i = 0;
            long j;
            for (int box : boxSizes) {
                j = binarySearch(packages, box + 1);
                currUsage += (j - i) * box;
                i = j;
            }
            
            if (currUsage < minUsage) {
                minUsage = currUsage;
            }
        }
        
        if (minUsage < Long.MAX_VALUE) {
            return (int) ((minUsage - totalPackageSize) % mod);
        }
        
        return -1;
    }
    
    // UPPER BOUND BINARY SEARCH
    // https://stackoverflow.com/questions/28389065/difference-between-basic-binary-search-for-upper-bound-and-lower-bound
    // returns the index of the largest package that can be put in the box
    public int binarySearch(int[] packages, int box) {
        int l = 0;
        int r = packages.length; // because of upper bound (upper bound occurs on right of index)
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (packages[mid] < box) {
                l = mid + 1;
            } else if (packages[mid] >= box) {
                r = mid;
            }
        }
        return l;
    }
}
