public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1)
            return A.length;
        int i = 0;
        for (int j = 1; j < A.length; j++){
            if(A[i] != A[j])
                A[++i] = A[j];
        }
        //i is the ith in the array, i + 1 is the length
        return i + 1;
    }
}