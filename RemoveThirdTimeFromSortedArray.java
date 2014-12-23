public class Solution {
    public int removeDuplicates(int[] A) {
        //caution limitation length of 2
        if(A.length <= 2)
            return A.length;
        int current = 2;
        int previous = 1;
        while(current < A.length){
            //algorithm
            if(!(A[current] == A[previous] && A[current] == A[previous - 1]))
                A[++ previous] = A[current ++];
            else
                current ++;
        }
        return previous + 1;
    }
}