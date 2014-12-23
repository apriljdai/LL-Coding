public class Solution {
    public int firstMissingPositive(int[] A) {
        Arrays.sort(A);
        int index = 0;
        int n = 1;
        while (index < A.length && A[index] <= 0){//have to set the index < A.length to make the boundary
            index ++;
        }
        for (int i = index; i < A.length; i++){
            if (i > 0 && A[i] == A[i - 1])//have to set i > 0 to make the boundary
                continue;//consider the duplicate solution in the array
            else if (A[i] != n)
                return n;
            else
                n++;
        }
        return n;
    }
}//runtime: O(NlogN) maybe?
public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length, i = 0;
        while (i < n){
            if (A[i] > 0 && A[i] <= n && A[i] - 1 != i && A[A[i] - 1] != A[i]){//why those situations?
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
            else
                i++;
        }
        for(int j = 0; j < n; j++){
            if(A[j] != j + 1)
                return j + 1;
        }
        return n+1;
    }
}//runtime: O(N)