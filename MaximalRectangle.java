public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;//have to write here not with the row since the boundary case should be defined first
        int[][] ones = new int[row][col];
        //the ones matrix is used to count the continuous number of 1 in each row
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == '1'){
                    if (j == 0)
                        ones[i][j] = 1;
                    else
                        ones[i][j] = ones[i][j - 1] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int minHeight = i;
                int minWidth = ones[i][j];
                while(minHeight >= 0){
                    //have to consider the upper row value
                    minWidth = Math.min(minWidth, ones[minHeight][j]);
                    int area = minWidth * (i - minHeight + 1);
                    max = Math.max(max, area);
                    minHeight--;
                }
            }
        }
        return max;
    }
}