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
        // sort intervals using first key
        // iterate over sorted intervals
            // if mergedIntervals is empty
                // add the first interval
            // if mergedIntervals is not empty
                // if the lastInterval's end value > currInterval's start
                    // lastInterval's end value = max(lastInterval's end, currInterval's end)
        // BEST
        quicksort(intervals, 0, intervals.length - 1);
        
        // BETTER
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // BAD: so long
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     public int compare(int[] a, int[] b) {
        //         // if a[0] < b[0] -> return -
        //         // if a[0] == b[0] -> return 0
        //         // if a[0] > b[0] -> return +
        //         return a[0] - b[0];
        //     }
        // });
        
        int index = 0;
        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        mergedIntervals.add(intervals[0]);
            
        
        for (int i = 1; i < intervals.length; i++) {
            int prevEnd = mergedIntervals.getLast()[1];
                
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            
            if (prevEnd >= currStart) {
                mergedIntervals.getLast()[1] = Math.max(prevEnd, currEnd);
            } else {
                mergedIntervals.add(intervals[i]);
            }
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
    
    private void quicksort(int[][] nums, int start, int end) {
        if (start >= end) return;
        int l = start;
        int r = end;
        int pivot = nums[end][0];
        while (l < r) {
            while (l < r && nums[l][0] <= pivot) 
                l++;
            while (l < r && nums[r][0] >= pivot)
                r--;
            swap(nums,l,r);
        }
        swap(nums,l,end);
        quicksort(nums,l+1,end);
        quicksort(nums,start,l-1);
    }

    private void swap(int[][] arr, int a, int b) {
        int[] tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}