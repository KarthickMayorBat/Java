package SearchingProblems;

import java.util.Arrays;
/*
 * You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples :

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.
Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.
 */
public class AggressiveCows {

    // Function to determine if cows can be placed at minDist distance apart
    public static boolean canPlaceCows(int[] stalls, int k, int minDist) {
        int count = 1; // Place the first cow at the first stall
        int lastPlaced = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= minDist) {
                count++;
                lastPlaced = stalls[i];
            }
            if (count == k) return true; // Successfully placed all cows
        }
        return false; // Not enough stalls to place all cows
    }

    public static int findMaxMinDistance(int[] stalls, int k) {
        // Step 1: Sort the stall positions
        Arrays.sort(stalls);
        
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        // Step 2: Perform binary search on distance
        while (low <= high) {
            int mid = low + (high - low) / 2; // Candidate minimum distance

            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update result to the current mid
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Reduce the search range
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9}; // Example stall positions
        int k = 3; // Number of cows

        int maxMinDistance = findMaxMinDistance(stalls, k);
        System.out.println("The largest minimum distance is: " + maxMinDistance);
    }
}

