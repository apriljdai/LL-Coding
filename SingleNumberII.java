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