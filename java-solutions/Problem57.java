/*
    57. Insert Interval

    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
    Return intervals after the insertion.

    Example 1:
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

    Example 2:
    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
    
    Constraints:
    0 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 105
    intervals is sorted by starti in ascending order.
    newInterval.length == 2
    0 <= start <= end <= 105
 */

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // APPROACH 2
        List<int[]> result = new ArrayList<>();
        
        int n = intervals.length;
        boolean isNewIntervalAdded = false;
        
        for (int i = 0; i < n; i++) {
            if (isNewIntervalAdded) {
                result.add(intervals[i]);
                continue;
            }
            
            if (newInterval[1] < intervals[i][0]) { // end of new interval is before the start of interval
                result.add(newInterval);
                result.add(intervals[i]);
                isNewIntervalAdded = true;
            } else if (newInterval[0] > intervals[i][1]) { // start of new interval is after end of interval
                result.add(intervals[i]);
            } else { // interval occurs between
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        
        if (!isNewIntervalAdded) {
            result.add(newInterval);
        }
        
        
        // APPROACH 1
//         // add all intervals occuring before newInterval
//         while(i < n && newInterval[0] > intervals[i][1]) {
//             result.add(intervals[i++]);
//         }
        
//         // if there is a merge we first find the intervals that could merge and newIntervals start and end
//         // [oldStart newStart newEnd oldEnd]
//         while(i < n && intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
//             newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
//             newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
//             i++;
//         }
        
//         result.add(newInterval);
        
//         while(i < intervals.length) {
//             result.add(intervals[i++]);
//         }
        
        return result.toArray(new int[result.size()][2]);
    }
}
