/*
Majority Element
 
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] num) {
        int time = num.length;
        if (time == 1){
            return num[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num){
            if (!map.containsKey(n)){
                map.put(n, 1);
            }
            else{
                int temp = map.get(n) + 1;
                if (temp > time / 2){
                    return n;
                }
                else{
                    map.put(n, temp);
                }
            }
        }
        return 0;
    }
}