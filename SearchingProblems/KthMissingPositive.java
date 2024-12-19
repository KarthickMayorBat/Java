package SearchingProblems;
/*
 * Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

Examples :

Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
Input: arr[] = [1, 2, 3], k = 2
Output: 5
Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
Output: 2
Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.
Constraints:
1 <= arr.size() <= 105
1 <= k <= 105
1 <= arr[i]<= 106
 */
public class KthMissingPositive {
    public int kthMissing(int[] arr, int k) {
        // code here
        int n = arr.length;
        int result = n+k;
        int low = 1;
        int high = arr[n-1];
        while(low<=high){
            int mid = low + (high-low)/2;
            if(find(arr, k, mid, n)){
                result = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
    public boolean find(int[] arr,int k,int num,int n){
        int i=1, j=0;
        int count = 0;
        while(i<=num && j<n){
            if(arr[j] != i){
                count++;
                i++;
            }else{
                j++;
                i++;
            } 
            if(count == k) return true;
        }
        return false;
    }
}
