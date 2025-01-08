import java.util.Arrays;

public class TrianglePairs {
    public int countTriangles(int[] arr) {
        Arrays.sort(arr); // Sort the array
        int res = 0;      // Initialize the result
        int n = arr.length;

        // Fix the largest side (arr[c])
        for (int c = n - 1; c > 1; c--) {
            int i = 0, j = c - 1;

            // Use two-pointer technique
            while (i < j) {
                if (arr[i] + arr[j] > arr[c]) {
                    // Add all valid pairs between i and j
                    res += (j - i);
                    j--; // Decrease the larger side
                } else {
                    i++; // Increase the smaller side
                }
            }
        }

        return res;
    }
}
