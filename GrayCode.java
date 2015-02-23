/*
 Gray Code
 
 The gray code is a binary numeral system where two successive values differ in only one bit.
 
 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 
 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.
 
 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> intToGray = new ArrayList<Integer>();
        int size = (int)Math.pow(2,n);
        //must add cast in front of Math since pow returns long
        for (int i = 0; i < size; i++){
            intToGray.add(i ^ (i >> 1));
            //integer to gray code algorithm: binary i right move 1 bit, then XOR to the origional i
        }
        return intToGray;
    }
}