package SlidingWindow;
import java.util.ArrayList;
import java.util.HashMap;
/*
 * Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
 */
public class CountDistinct {

    public static ArrayList<Integer> countUniqueInSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        // Validate input
        if (k > n) {
            return result; // Return empty result if k is larger than the array
        }

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the element going out of the window
            int outElement = arr[i - k];
            map.put(outElement, map.get(outElement) - 1);
            if (map.get(outElement) == 0) {
                map.remove(outElement);
            }

            // Add the new element
            int inElement = arr[i];
            map.put(inElement, map.getOrDefault(inElement, 0) + 1);

            // Add the unique count to the result
            result.add(map.size());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 3, 4, 3};
        int k = 4;
        ArrayList<Integer> result = countUniqueInSubarrays(arr, k);

        System.out.println(result); // Output: [3, 3, 4, 3]
    }
}