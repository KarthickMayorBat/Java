package SlidingWindow;

import java.util.ArrayList;
/*
 * Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].

Examples:

Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.
Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.
Input: arr[] = [5, 3, 4], target = 2
Output: [-1]
Explanation: There is no subarray with sum 2.
 */

public class SubarrayPairs {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int fI = 0; // Start pointer
        int sum = 0; // Current sum of the sliding window
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
    
        for (int i = 0; i < n; i++) {
            // Expand the window by adding arr[i]
            sum += arr[i];
    
            // Shrink the window while sum > target
            while (sum > target && fI <= i) {
                sum -= arr[fI];
                fI++;
            }
    
            // Check if we found the target sum
            if (sum == target) {
                result.add(fI + 1); // Add 1-based index for start
                result.add(i + 1);  // Add 1-based index for end
                return result;
            }
        }
        result.add(-1);
        // No subarray found
        return result;
    }
}
