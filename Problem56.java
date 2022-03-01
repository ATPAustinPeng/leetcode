/* 
    56. Merge Intervals
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
    
    Example 1:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    Example 2:
    Input: intervals = [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.

    Constraints:
    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104
*/
public class Problem 56 {
    public int[][] merge(int[][] intervals) {
        // sort the array by x[0] then by y[0] if the x[0]'s are equal
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        LinkedList<int[]> solution = new LinkedList<>();

        // loop through sorted intervals
        // if solution set is empty, add the first interval we see
        // OR add the first interval where the first value > solution.getLast()'s second value
            // ex. solution = {[1, 2], [3, 15]}, arr = [29, 50]
            // because 29 > 15, we want to add the interval because no merging is needed
        // otherwise
            // if the interval's second value > solution.getLast()[1], update solution.getLast()[1] with the max(interval[1], solution.getLast()[1])
            // ex. solution = {[1, 2], [3, 15]}, arr = [10, 30]
            // because 30 > 15, we want to merge interval to [3, 30]
        for (int[] arr : intervals) {
            if (solution.isEmpty() || solution.getLast()[1] < arr[0]) {
                solution.add(arr);
            } else {
                solution.getLast()[1] = Math.max(arr[1], solution.getLast()[1]);
            }
        }
        return solution.toArray(new int[solution.size()][]);
    }
}