public class Solution {
    public boolean canJump(int[] A) {
        //base case: length <= 1
        //base case: A[0] >= length
        if(A.length <= 1 || A[0] >= A.length)
            return true;
        //base case: A[0] == 0
        else if(A[0] == 0)
            return false;
        //set the maxLength see if can get to the final index
        int maxLength = A[0];
        for(int i = 1; i < A.length; i++){
            //have to be >=, or [2 0 0] is wrong
            if(maxLength >= i && (i + A[i]) >= (A.length - 1))
                return true;
            if((i + A[i] > maxLength))
                maxLength = i + A[i];
            //have to be <=, or [2 0 1] is wrong
            if(maxLength <= i && A[i] == 0)
                return false;
        }
        return true;
    }
}