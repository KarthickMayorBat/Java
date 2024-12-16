package SearchingProblems;
/*
 * Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.
 */


class KthElementOfTwoArrays {
    public static int findKthElement(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;
        int i = 0, j = 0, count = 0;

        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                count++;
                if (count == k) return a[i];
                i++;
            } else {
                count++;
                if (count == k) return b[j];
                j++;
            }
        }

        while (i < n1) {
            count++;
            if (count == k) return a[i];
            i++;
        }

        while (j < n2) {
            count++;
            if (count == k) return b[j];
            j++;
        }

        return -1; // If k is invalid
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5; // Example: Find the 5th smallest element

        int result = findKthElement(a, b, k);
        if (result != -1) {
            System.out.println("The " + k + "th smallest element is: " + result);
        } else {
            System.out.println("Invalid value of k.");
        }
    }
}