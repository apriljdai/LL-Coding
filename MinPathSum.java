public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        //initial the left and the top
        result[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            result[i][0] = grid[i][0] + result[i - 1][0];
        //since it only caculate two blocks, so we have to add the number before that
        for (int j = 1; j < n; j++)
            result[0][j] = grid[0][j] + result[0][j - 1];
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                result[i][j] = grid[i][j] + Math.min(result[i - 1][j], result[i][j - 1]);
            }
        }
        return result[m - 1][n - 1];
    }
}