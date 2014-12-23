public class Solution {
    public void sortColors(int[] A) {
        if(A == null)
            return;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < i; j++){
                if(A[i] < A[j]){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    continue;
                }
            }
        }
    }
}