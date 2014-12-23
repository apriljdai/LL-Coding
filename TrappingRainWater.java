public class Solution {
    public int trap(int[] A) {
        if(A == null || A.length <= 2)
            return 0;
        //left to right to fill the blank
        int max = A[0];
        int index = 0;
        int[] fixTrap = new int[A.length];
        for (int i = 0; i < A.length; i++){
            //i must be 0 instead of 1, or fixTrap will lost the first value
            if(A[i] > max){
                max = A[i];
                index = i;
            }
            fixTrap[i] = max;
        }
        //max to right to delete the over calucated space
        int maxRight = A[A.length - 1];
        for (int j = A.length - 1; j > index; j--){
            if (A[j] > maxRight)
                maxRight = A[j];
            fixTrap[j] = maxRight;
        }
        //difference between original and fixed figure
        int sum = 0;
        for (int k = 0; k < A.length; k++){
            sum += fixTrap[k] - A[k];
        }
        return sum;
    }
}