public class Solution {
    public int longestConsecutive(int[] num) {
        //not increase the runtime, just increase the space when using the HashSet
        HashSet<Integer> numSeq = new HashSet<Integer>();
        for(int i: num){
            numSeq.add(i);
        }
        int max = 1;
        for(int i: num){
            int less = i - 1;
            int more = i + 1;
            int count = 1;
            while(numSeq.contains(less)){
                count++;
                numSeq.remove(less);
                less--;
            }
            while(numSeq.contains(more)){
                count++;
                numSeq.remove(more);
                more++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
//cannot use sort function since runtime is O(NlogN)