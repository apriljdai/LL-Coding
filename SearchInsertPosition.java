public class Solution {
    public int searchInsert(int[] A, int target) {
        int index = A.length;
        for(int i = 0; i < A.length; i++){
            if ((A[i] == target) || (target < A[i])){
                index = i;
                break;
            }
        }
        return index;
    }
}
//runtime:N

    public int searchInsert(int[] A, int target) {
        if(A == null)
            return -1;
        int low = 0, high = A.length - 1;
        while(low <= high){
            int m = (low + high) / 2;
            if(A[m] == target)
                return m;
            if(A[m] > target)
                high = m - 1;
            else low = m + 1;
        }
        return low;
    }
//runtime:logN
