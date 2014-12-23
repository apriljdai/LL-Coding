public class Solution {
    public void rotate(int[][] matrix) {
        //in-place：原地分割法
        // a | b
        // c | d
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++){
            for (int j = 0; j < Math.ceil((double)n / 2.0); j++){
                int temp = matrix[i][j];
                //c -> a
                matrix[i][j] = matrix[n - 1 - j][i];
                //d -> c
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                //b -> d
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                //a -> b
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}