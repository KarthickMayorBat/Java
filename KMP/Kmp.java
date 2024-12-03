package KMP;

import java.util.*;

public class Kmp {

    public static int minimizeDifference(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        Arrays.sort(arr);

        // Initial difference between max and min
        int init_diff = arr[n - 1] - arr[0];

        // Initialize minHeight and maxHeight
        int minHeight = arr[0] + k;
        int maxHeight = arr[n - 1] - k;

        // Ensure minHeight is always smaller
        if (minHeight > maxHeight) {
            int temp = minHeight;
            minHeight = maxHeight;
            maxHeight = temp;
        }

        // Iterate through the array and calculate possible ranges
        for (int i = 0; i < n - 1; i++) {
            int currentMaxHeight = Math.max(maxHeight, arr[i] + k);
            int currentMinHeight = Math.min(minHeight, arr[i + 1] - k);

            // Skip if currentMinHeight is negative
            if (currentMinHeight < 0) continue;

            init_diff = Math.min(init_diff, currentMaxHeight - currentMinHeight);
        }

        return init_diff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 10};
        int k = 2;
        System.out.println("Minimum possible difference: " + minimizeDifference(arr, k));

        int[] arr2 = {2, 6, 3, 4, 7, 2, 10};
        int k2 = 5;
        System.out.println("Minimum possible difference: " + minimizeDifference(arr2, k2));

        int[] arr3 = {1, 15, 10};
        int k3 = 6;
        System.out.println("Minimum possible difference: " + minimizeDifference(arr3, k3));
    }
}