public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length == 0)
            return 0;
        if (A.length == 1){
            if(A[0] == elem)
                return 0;
            else
                return 1;
        }
        int j = 0;
        for(int i: A){
            if(i != elem){
                A[j] = i;
                j++;
            }
        }
        return j;
    }
}