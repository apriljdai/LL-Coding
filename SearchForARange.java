public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0)
            return null;
        int[] result = new int[2];
        result[0] = searchRange(A, target, 0, A.length - 1);
        result[1] = searchRange(A, target + 1, 0, A.length - 1);
        if (result[0] == result[1]){
            result[0] = -1;
            result[1] = -1;
        }
        else
            result[0] ++;
        return result;
    }
    public int searchRange(int[] A, int target, int start, int end){
        if (start == end)
            return A[start] < target ? start : start - 1;
        if (start == end - 1)
            return A[end] < target ? end : (A[start] < target ? start : start - 1);
        int middle = (start + end) / 2;
        if (A[middle] >= target)
            end = middle - 1;
        else
            start = middle;
        return searchRange(A, target, start, end);
    }
}