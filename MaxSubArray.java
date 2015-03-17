/*
 Maximum Subarray
 
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 
 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 
 More practice:
 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Solution {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            maxSum = Math.max(maxSum, sum);
            // make sure the begin of the subArray is positive
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}