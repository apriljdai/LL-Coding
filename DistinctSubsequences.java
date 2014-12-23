public class Solution {
    public int numDistinct(String S, String T) {
        int[][] temp = new int[S.length() + 1][T.length() + 1];
        temp[0][0] = 1;// if S & T are all empty
        for (int i = 1; i <= S.length(); i++){
            temp[i][0] = 1;// if T is empty
        }
        for (int j = 1; j <= T.length(); j++){
            temp[0][j] = 0;// if S is empty
        }
        for (int i = 1; i <= S.length(); i++){
            for (int j = 1; j <= T.length(); j++){
                temp[i][j] = temp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1))
                    temp[i][j] += temp[i - 1][j - 1];
            }
        }
        return temp[S.length()][T.length()];
    }
}