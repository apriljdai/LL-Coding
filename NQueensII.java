public class Solution {
    int count;
    public int totalNQueens(int n) {
        count = 0;
        int[] location = new int[n];
        totalNQueens(n, location, 0);
        return count;
    }
    public void totalNQueens(int n, int[] location, int current){
        if (current == n){
            count ++;
            return;
        }
        else{
            for (int i = 0; i < n; i++){
                location[current] = i;
                if (isValid(location, current))
                    totalNQueens(n, location, current + 1);
            }
        }
    }
    public boolean isValid(int[] location, int current){
        for (int i = 0; i < current; i++){
            if (location[i] == location[current] || Math.abs(location[i] - location[current]) == (current - i))
                return false;
        }
        return true;
    }
}