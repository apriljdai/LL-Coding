public class Solution {
    public int search(int[] A, int target) {
        int result = -1;
        if(A == null || A.length == 0)
            return result;
        for(int i = 0; i < A.length; i++){
            if (A[i] == target){
                result = i;
                break;
            }
        }
        return result;
    }
}
//run-time: O(N)

public class Solution {
    public int search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (target == A[middle])
                return middle;
            if (A[middle] < A[right]){
                if (target > A[middle] && target <= A[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
            else{
                if (target < A[middle] && target >= A[left])
                    right = middle - 1;
                else
                    left = middle + 1;
            }
        }
        return -1;
    }
}
//run-time: O(logN)