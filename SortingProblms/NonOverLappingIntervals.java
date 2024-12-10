/*
 * Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 
 Examples:
 
 Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
 Output: 1
 Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.
 Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
 Output: 2
 Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.
 Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
 Output: 0
 Explanation: All ranges are already non overlapping.
 */

import java.util.Arrays;

public class NonOverLappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1]; // Initialize with the end of the first interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) { 
                count++;
            } else {
                // No overlap, update end to current interval's end
                end = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 3}
        };
        
        System.out.println(eraseOverlapIntervals(intervals)); // Output: 1
    }
}
