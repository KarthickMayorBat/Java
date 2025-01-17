package PrefixSum;

/*
 * 
Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.

Examples:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
Input: arr[] = [12, 0]
Output: [0, 12]
Explanation: For i = 0, res[i] is 0.
For i = 1, res[i] is 12.
 */

public class ProductArrayPuzzle {
    //method 1
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int[] prePro = new int[n];
        int[] sufPro = new int[n];
        prePro[0] = 1; // 1,1,2,6
        for(int i=1; i<n; i++){ // 1,2,3,4 
            prePro[i] = prePro[i-1]*arr[i-1];
        }
        sufPro[n-1] = 1;// , , , 1
        for(int i=n-2; i>=0; i--){ //4, 3, 2, 1
            sufPro[i] = sufPro[i+1]*arr[i+1];
        }
        for(int i=0; i<n; i++){
            result[i] = prePro[i]*sufPro[i];
        }
        return result;
    }
    //m3thod 2
    public static int[] productExceptSelf1(int[] arr){
        int product = 1;
        int zeroCount = 0;
        for(int ele : arr){
            if(ele == 0){
                zeroCount++;
            }
            product = product * ((ele == 0) ? 1 : ele);
        }
        int n = arr.length;
        int[] result = new int[n];
        
        for(int i=0; i<n; i++){
            if(zeroCount==0){
                result[i] = product/arr[i];
            }else if(zeroCount==1){
                result[i] = ((arr[i] == 0) ? product : 0);
            }else{
                result[i] = 0;
            }
        }
        return result;
    }
}
