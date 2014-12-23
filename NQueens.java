public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        //use array to present the location of Q
        int[] location = new int[n];
        solveNQueens(n, result, location, 0);
        return result;
    }
    public void solveNQueens(int n, ArrayList<String[]> result, int[] location, int current){
        if (current == n)
            printBoard(location, result, n);
        else{
            for (int i = 0; i < n; i++){
                location[current] = i;
                if (isValid(location, current))
                    solveNQueens(n, result, location, current + 1);
            }
        }
    }
    // N queens rule: no two queens share the same row, column, or diagonal
    public boolean isValid(int[] location, int current){
        for (int i = 0; i < current; i++){
            if (location[i] == location[current] || Math.abs(location[current] - location[i]) == (current - i))
                return false;
        }
        return true;
    }
    public void printBoard(int[] location, ArrayList<String[]> result, int n){
        String[] ans = new String[n];
        for (int i = 0; i < n; i++){
            String row = new String();
            for (int j = 0; j < n; j++){
                if (location[i] == j)
                    row += "Q";
                else
                    row += ".";
            }
            ans[i] = row;
        }
        result.add(ans);
    }
}