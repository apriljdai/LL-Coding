/*
Find Minimum in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] num) {
        int res = findMin(num, 0, num.length - 1);
        return res;
    }
    public int findMin(int[] num, int start, int end){
        while(start <= end){
            if (start == end)
                return num[start];
            if (end - start == 1)
                return Math.min(num[start], num[end]);
            int mid = (start + end) / 2; 
            //7 0 1 2 4 5 6 mid < start && mid < end => end = mid
            //4 5 6 7 0 1 2 mid > start && mid > end => start = mid
            //0 1 2 4 5 6 7 mid > start && mid < end => end == mid
            if (num[mid] > num[start] && num[mid] > num[end]){
                start = mid + 1;
            }
            if (num[mid] < num[end]){
                end = mid;
            }
        }
        return num[start];
    }
}