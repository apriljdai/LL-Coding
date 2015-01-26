/*
Factorial Trailing Zeroes
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0){
            int temp = n / 5;
            count += temp;
            n = temp;
        }
        return count;
    }
}
