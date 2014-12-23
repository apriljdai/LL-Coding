public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] newMatrix = new int[row][col];
        //define the beginning of the matrix
        if (obstacleGrid[0][0] == 1)
            newMatrix[0][0] = 0;
        else
            newMatrix[0][0] = 1;
        //build the most left and top of the matrix
        for (int i = 1; i < row; i++){
            if (obstacleGrid[i][0] == 1)
                newMatrix[i][0] = 0;
            else
                newMatrix[i][0] = newMatrix[i - 1][0];
        }
        for (int j = 1; j < col; j++){
            if (obstacleGrid[0][j] == 1)
                newMatrix[0][j] = 0;
            else
                newMatrix[0][j] = newMatrix[0][j - 1];
        }
        //same method as the unique path
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                if (obstacleGrid[i][j] == 1)
                    newMatrix[i][j] = 0;
                else
                    newMatrix[i][j] = newMatrix[i - 1][j] + newMatrix[i][j - 1];
            }
        }
        return newMatrix[row - 1][col - 1];
    }
}