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
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        LinkedList<int[]> solution = new LinkedList<>();
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