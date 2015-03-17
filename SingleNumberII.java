/*
 Single Number II
 
 Given an array of integers, every element appears three times except for one. Find that single one.
 
 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> singleNumber = new HashMap<Integer, Integer>();
        for (int a : A){
            if (singleNumber.containsKey(a))
                singleNumber.put(a, singleNumber.get(a) + 1);
            else
                //have to write else, or the statement would compile every time, the value would always be 1
                singleNumber.put(a, 1);
        }
        for (Integer i: singleNumber.keySet()){
            if(singleNumber.get(i) != 3)
                return i;
        }
        return 0;
    }
}
//runtime: O(N), memory: O(N)

public class Solution {
    public int singleNumber(int[] A) {
        int once = 0, twice = 0, three = 0;
        for (int i = 0; i < A.length; i++){
            twice |= once & A[i];
            once ^= A[i];
            three = once & twice;
            once &= ~three;
            twice &= ~three;
        }
        return once;
    }
}
//runtime: O(N), memory: O(1)
