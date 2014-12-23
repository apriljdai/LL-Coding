public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0)
            return false;
        for (int i = 0; i < A.length; i++){
            if (A[i] == target){
                return true;
            }
        }
        return false;
    }
}
//run-time: O(N)

public class Solution {
    public boolean search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (target == A[middle])
                return true;
            if (A[middle] > A[left]){
                if (A[middle] > target && A[left] <= target)
                    right = middle - 1;
                else
                    left = middle + 1;
            }
            else if (A[middle] < A[left]){
                if (A[middle] < target && A[right] >= target)
                    left = middle + 1;
                else
                    right = middle - 1;
            }
            else
                left ++;
        }
        return false;
    }
}
//run-time: O(N)