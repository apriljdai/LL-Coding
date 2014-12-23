public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0 || A.length == 1){
            return 0;
        }
        int start = 0, end = 0, step = 0, max = 0;
        while (end < A.length){
            max = 0;
            step ++;
            for (int i = start; i <= end; i++){
                if ((A[i] + i) >= (A.length - 1)){
                    return step;
                }
                if((A[i] + i) > max){
                    max = A[i] + i;
                }
            }
            start = end + 1;
            end = max;
        }
        return step;
    }
}
/*
 public class Solution {
    public int jump(int[] A) {
        if (A== null || A.length == 0)
            return 0;
        int[] max = new int[A.length];
        for (int i = 0; i < A.length; i++){
            max[i] = A[i] + i;
        }
        int start = 0, end = A.length - 1, step = 0;
        while(end > 0) {
            step ++;
            for (int i = start; i <= end; i++) {
                if(max[i] >= (A.length-1)) {
                    end  = i;
                    break;
                }
            }
        }
        return step;
    }
 }
 */