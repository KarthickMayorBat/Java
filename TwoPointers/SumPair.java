package TwoPointers;
/*
 * Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such that the sum of there elements is equals to target.

Examples:

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16.
Input: arr[] = [1, 2, 4, 3, 6], target = 11
Output: false
Explanation: None of the pair makes a sum of 11.

The two pointer problem requires solving n all, which is unneccessary i felt. I hope this method is efficient.
 */
import java.util.HashSet;

public class SumPair {
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        set.add(target-arr[0]);
        for(int i=1; i<n; i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(target-arr[i]);
        }
        return false;
    }
}
