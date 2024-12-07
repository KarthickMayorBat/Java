/*

 */

public class Inversions {
    static int inversionCount(int arr[]) {
        // Your Code Here
        return sort(arr, 0, arr.length-1);
        
    }
    static int sort(int[] arr, int l, int r){
        int count  = 0;
        if(l<r){
            int mid = l + (r-l)/2;
            count += sort(arr, l, mid); 
            count += sort(arr, mid+1, r);
            count += findCount(arr, l ,mid, r);
        }
        return count;
    }
    static int findCount(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
    
        // Create temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];
    
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) left[i] = arr[l + i];
        for (int i = 0; i < n2; i++) right[i] = arr[mid + 1 + i];
    
        int i = 0, j = 0, k = l, inversions = 0;
    
        // Merge the two arrays and count inversions
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                inversions += (n1 - i); // Count all inversions for left[i] to left[n1-1]
            }
        }
    
        // Copy remaining elements
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    
        return inversions;
    }
}
