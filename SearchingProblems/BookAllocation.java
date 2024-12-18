public class BookAllocation {

    // Function to check if the allocation is possible for a given maxPages
    private static boolean isPossible(int[] arr, int n, int k, int maxPages) {
        int studentCount = 1; // Start with one student
        int currentSum = 0; // Current pages for the student

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxPages) {
                return false; // Cannot assign this book as it exceeds the allowed pages
            }

            if (currentSum + arr[i] > maxPages) {
                studentCount++; // Allocate to a new student
                currentSum = arr[i];

                if (studentCount > k) {
                    return false; // Too many students required
                }
            } else {
                currentSum += arr[i];
            }
        }

        return true; // Allocation possible
    }

    // Main function to find the minimum of the maximum pages
    public static int findMinPages(int[] arr, int n, int k) {
        if (n < k) {
            return -1; // Not enough books for students
        }

        int low = Integer.MIN_VALUE; // Minimum possible maxPages
        int high = 0; // Maximum possible maxPages

        for (int pages : arr) {
            low = Math.max(low, pages); // The maximum single book
            high += pages; // Sum of all pages
        }

        int result = -1;

        // Binary search on the range of maxPages
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, k, mid)) {
                result = mid; // Update result if allocation is possible
                high = mid - 1; // Search for a better minimum in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90}; // Pages in books
        int k = 2; // Number of students
        int n = arr.length;

        int result = findMinPages(arr, n, k);
        System.out.println("The minimum of the maximum pages is: " + result);
    }
}

