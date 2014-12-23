public class Solution {
    public int minCut(String s) {
        int min = 0;
        if (s == null || s.length() == 0)
            return min;
        int[] cuts = new int[s.length() + 1];
        //s.substring(i, j) is palindrome if matrix[i][j] == true
        boolean[][] matrix = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            //the max number of cuts for each s.substring(i)
            cuts[i] = s.length() - i;
        for (int i = s.length() - 1; i >= 0; --i){
            for (int j = i; j < s.length(); ++j){
                if ((s.charAt(i) == s.charAt(j) && (j - i < 2)) || (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1])){
                    //two situations
                    //1: i and j are neighbors or the same
                    //2: the chars between i and j are also palindrome
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        min = cuts[0];
        return min - 1;
    }
}