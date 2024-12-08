import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:
Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
Output: [[1,4], [6,8], [9,10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].

Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
Output: [[1,9]]
Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].
 */

class MergeInversions{
    public static List<int[]> mergeOverlap(int[][] arr) {
         Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
         int st = arr[0][0];
         int en = arr[0][1];
         List<int[]> result = new ArrayList<>();
         for(int i=1; i<arr.length; i++){
             if (en >= arr[i][0]) {
                // Overlapping intervals
                en = Math.max(en, arr[i][1]);
            } else {
                // No overlap, add the previous interval
                result.add(new int[]{st, en});
                st = arr[i][0];
                en = arr[i][1];
            }
         }
         result.add(new int[]{st,en});
         return result;
    }
    public static void main(String[] args){
        int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        List<int[]> result = mergeOverlap(arr);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}