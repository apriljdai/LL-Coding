/*  Single Number
    Given an array of integers, every element appears twice except for one. 
    Find that single one.
    Note: 
    Your algorithm should have a linear runtime complexity. 
 */


public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for(int a: A){
            res = res ^ a;
            //XOR algorithm, in binary, same value get 0 and different value get 1.
            //finally twice number all become 0 only left the single time number.
        }
        return res;
    }
}