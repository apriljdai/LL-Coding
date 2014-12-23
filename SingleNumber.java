/*  Single Number
    Given an array of integers, every element appears twice except for one. 
    Find that single one.
    Note: 
    Your algorithm should have a linear runtime complexity. 
 */


public class Solution {
    public int singleNumber(int[] A) {
        int x = 0;
        for(int i: A){
            x = x ^ i;
            //XOR algorithm, in binary, same value get 0 and different value get 1.
            //finally twice number all become 0 only left the single time number.
        }
        return x;
    }
}