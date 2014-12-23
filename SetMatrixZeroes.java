public class Solution {
    public void setZeroes(int[][] matrix) {
        //check if the first row or column has 0
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                firstRow = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++){
            if (matrix[0][j] == 0){
                firstCol = true;
                break;
            }
        }
        //mark all the 0 in the matrix to the first row and column
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //set all the marked elements into 0
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        //set the whole first row or column to 0 if they has 0 at original
        if (firstRow){
            for (int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if (firstCol){
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
    }
}